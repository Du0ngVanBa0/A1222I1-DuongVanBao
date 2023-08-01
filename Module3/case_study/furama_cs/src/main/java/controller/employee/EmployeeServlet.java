package controller.employee;

import model.*;
import service.division.DivisionServiceImpl;
import service.education_degree.EducationDegreeServiceImpl;
import service.employee.EmployeeServiceImpl;
import service.position.PositionServiceImpl;
import service.user.UserServiceImpl;
import util.Validate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {
    private UserServiceImpl userService = new UserServiceImpl();
    private PositionServiceImpl positionService = new PositionServiceImpl();
    private EducationDegreeServiceImpl educationDegreeService = new EducationDegreeServiceImpl();
    private DivisionServiceImpl divisionService = new DivisionServiceImpl();

    private EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "login":
                showLoginForm(request, response);
                break;
            case "delete":
                doDeleteByID(request, response);
                break;
            case "create":
                showCreateForm(request, response);
                break;
            case "list":
                showListForm(request, response);
                break;
            case "search":
                showSearchPage(request, response);
                break;
        }
    }

    private void doDeleteByID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteByID(id);
        showListForm(request, response);
    }

    private void showSearchPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search_name = request.getParameter("kw_name");
        String search_name_trim = search_name.trim();
        String search_id = request.getParameter("kw_id");
        String search_id_trim = search_id.trim();
        List<Employee> employees = null;
        if (search_id_trim.equals("") && search_name_trim.trim().equals("")) {
            employees = employeeService.findAll();
        } else if (search_id_trim.equals("")) {
            employees = employeeService.findByName(search_name);
        } else {
            int id = -1;
            try {
                id = Integer.parseInt(search_id);
                if (search_name_trim.trim().equals("")) {
                    search_name = "1";
                }
                employees = employeeService.findByNameAndID(search_name, id);
            } catch (Exception e) {
                request.setAttribute("id_error", "id must be a integer number");
            }
        }
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("/WEB-INF/employee/list.jsp").forward(request, response);
    }

    private void showListForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = employeeService.findAll();
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("/WEB-INF/employee/list.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userService.findAll();
        List<Position> positions = positionService.findAll();
        List<EducationDegree> educationDegrees = educationDegreeService.findAll();
        List<Division> divisions = divisionService.findAll();
        request.setAttribute("users", users);
        request.setAttribute("positions", positions);
        request.setAttribute("education_degrees", educationDegrees);
        request.setAttribute("divisions", divisions);
        request.getRequestDispatcher("/WEB-INF/employee/create.jsp").forward(request, response);
    }

    private void showLoginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/employee/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "create":
                doCreate(request, response);
                break;
            case "list":
                showListForm(request, response);
                break;
            case "delete_all":
                doDeleteAll(request, response);
                break;
        }
    }

    private void doDeleteAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] ids = request.getParameterValues("ids");
        employeeService.deleteAllByID(ids);
        showListForm(request, response);
    }

    private void doCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isValid = true;
        String name = request.getParameter("name");
        Date birthday = null;
        try {
            birthday = Validate.stringToDate(request.getParameter("birthday"));
        } catch (ParseException e) {
            isValid = false;
            request.setAttribute("errorDate", "Wrong format Date");
        }
        String card_id = request.getParameter("id_card");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int position_id = Integer.parseInt(request.getParameter("position"));
        int education_degree_id = Integer.parseInt(request.getParameter("education_degree"));
        int division_id = Integer.parseInt(request.getParameter("division"));
        String username = request.getParameter("user");
        if (isValid) {
            Division division = divisionService.findByID(division_id);
            EducationDegree educationDegree = educationDegreeService.findByID(education_degree_id);
            Position position = positionService.findByID(position_id);
            User user = userService.findByUsername(username);
            Employee employee = new Employee(name, birthday, card_id, salary, phone, email, address, position, educationDegree, division, user);
            employeeService.add(employee);
            request.getRequestDispatcher("/employee?action=list").forward(request, response);
        } else {
            showCreateForm(request, response);
        }
    }
}
