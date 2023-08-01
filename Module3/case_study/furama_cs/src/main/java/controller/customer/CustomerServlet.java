package controller.customer;

import model.Customer;
import model.CustomerType;
import service.customer.CustomerServiceImpl;
import service.customer_type.CustomerTypeServiceImpl;
import util.Validate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    private CustomerTypeServiceImpl customerTypeService = new CustomerTypeServiceImpl();
    private CustomerServiceImpl customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "list":
                showListForm(request, response);
                break;
            case "delete":
                doDeleteCus(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "search":
                doSearch(request, response);
                break;
        }
    }

    private void doSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageStr = request.getParameter("current_page");
        int page = pageStr == null ? 1 : Integer.parseInt(request.getParameter("current_page"));
        int record = 2;
        List<Customer> customers = customerService.findAllByName(request.getParameter("kw"), page, record);
        int totalRecord = customers.size();
        int totalPage = totalRecord % record == 0 ? totalRecord / record : (totalRecord / record + 1);
        int[] pages = new int[totalPage];
        for (int i = 1; i <= totalPage; i++) {
            pages[i - 1] = i;
        }
        request.setAttribute("total_page", totalPage);
        request.setAttribute("page_number", pages);
        request.setAttribute("current_page", page);
        request.setAttribute("customer_list", customers);
        request.getRequestDispatcher("/WEB-INF/customer/list.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerType> customerTypes = customerTypeService.findALl();
        Customer this_customer = customerService.findByID(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("this_customer", this_customer);
        request.setAttribute("customer_types", customerTypes);
        request.getRequestDispatcher("/WEB-INF/customer/edit.jsp").forward(request, response);
    }

    private void doDeleteCus(HttpServletRequest request, HttpServletResponse response) throws IOException {
        customerService.deleteByID(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect("/customer");
    }

    private void showListForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String pageStr = request.getParameter("current_page");
        int page = pageStr == null ? 1 : Integer.parseInt(request.getParameter("current_page"));
        int record = 2;
        int totalRecord = customerService.countAll();
        List<Customer> customers = customerService.findAllWithPaging(page, record);
        int totalPage = totalRecord % record == 0 ? totalRecord / record : (totalRecord / record + 1);
        int[] pages = new int[totalPage];
        for (int i = 1; i <= totalPage; i++) {
            pages[i - 1] = i;
        }
        request.setAttribute("total_page", totalPage);
        request.setAttribute("page_number", pages);
        request.setAttribute("current_page", page);
        request.setAttribute("customer_list", customers);
        request.getRequestDispatcher("/WEB-INF/customer/list.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerType> customerTypes = customerTypeService.findALl();
        request.setAttribute("customer_types", customerTypes);
        request.getRequestDispatcher("/WEB-INF/customer/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
            return;
        }
        switch (action) {
            case "create":
                doCreate(request, response);
                break;
            case "edit":
                doEdit(request, response);
                break;
            case "list":
                showListForm(request, response);
                break;
        }
    }

    private void doCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isValid = true;
        int type_id = Integer.parseInt(request.getParameter("category_id"));
        String name = request.getParameter("name");
        Date birthday = null;
        try {
            birthday = Validate.stringToDate(request.getParameter("birthday"));
        } catch (ParseException e) {
            isValid = false;
            request.setAttribute("errorDate", "Wrong format Date");
        }
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String card_id = request.getParameter("id_card");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        if (isValid) {
            CustomerType customerType = customerTypeService.findByID(type_id);
            Customer customer = new Customer(customerType, name, birthday, gender, card_id, phone, email, address);
            customerService.add(customer);
            request.getRequestDispatcher("/customer?action=list").forward(request, response);
        } else {
            List<CustomerType> customerTypes = customerTypeService.findALl();
            request.setAttribute("customer_types", customerTypes);
            request.getRequestDispatcher("/WEB-INF/customer/create.jsp").forward(request, response);
        }
    }

    private void doEdit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        boolean isValid = true;
        int id = Integer.parseInt(request.getParameter("id"));
        int type_id = Integer.parseInt(request.getParameter("category_id"));
        String name = request.getParameter("name");
        Date birthday = null;
        try {
            birthday = Validate.stringToDate(request.getParameter("birthday"));
        } catch (ParseException e) {
            isValid = false;
            request.setAttribute("errorDate", "Wrong format Date");
        }
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        System.out.println(gender);
        String card_id = request.getParameter("id_card");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        if (isValid) {
            CustomerType customerType = customerTypeService.findByID(type_id);
            Customer customer = new Customer(id, customerType, name, birthday, gender, card_id, phone, email, address);
            customerService.edit(customer);
            request.getRequestDispatcher("/customer?action=list").forward(request, response);
        } else {
            List<CustomerType> customerTypes = customerTypeService.findALl();
            Customer this_customer = customerService.findByID(id);
            request.setAttribute("this_customer", this_customer);
            request.setAttribute("customer_types", customerTypes);
            request.getRequestDispatcher("/WEB-INF/customer/edit.jsp").forward(request, response);
        }
    }
}
