package controller;

import model.Role;
import model.User;
import service.Impl.RoleService;
import service.Impl.UserRoleService;
import service.Impl.UserService;
import util.Validate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "UserController", value = "/user")
public class UserController extends HttpServlet {
    private RoleService roleService = new RoleService();
    private UserService userService = new UserService();
    private UserRoleService userRoleService = new UserRoleService();

    private String last_kw = "";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "list":
                page(req, resp);
                break;
            case "edit":
                showEdit(req, resp);
                break;
            case "create":
                showInsert(req, resp);
                break;
            case "search":
                searchPage(req, resp);
                break;
            case "delete":
                deleteDo(req, resp);
                break;
        }
    }

    private void showEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        User user = userService.findById(id);
        req.setAttribute("user", user);
        List<Role> roles = roleService.findAll();
        req.setAttribute("roles", roles);
        req.getRequestDispatcher("/web/Edit.jsp").forward(req, resp);
    }

    private void deleteDo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        userService.delete(id);
        resp.sendRedirect("/user");
    }

    private void searchPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageStr = req.getParameter("current_page");
        int page = pageStr == null ? 1 : Integer.parseInt(req.getParameter("current_page"));
        int record = 2;
        String kw_name = req.getParameter("kw_name");
        if (kw_name != null) {
            last_kw = kw_name;
        } else {
            kw_name = last_kw;
        }
        int totalRecord = userService.countAllSearch(kw_name);
        List<User> users = userService.search(kw_name, page, record);
        int totalPage = totalRecord % record == 0 ? totalRecord / record : (totalRecord / record + 1);
        int[] pages = new int[totalPage];
        for (int i = 1; i <= totalPage; i++) {
            pages[i - 1] = i;
        }
        req.setAttribute("dispatcher", "search");
        req.setAttribute("total_page", totalPage);
        req.setAttribute("page_number", pages);
        req.setAttribute("current_page", page);
        req.setAttribute("users", users);
        req.getRequestDispatcher("web/List.jsp").forward(req, resp);
    }

    private void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageStr = req.getParameter("current_page");
        int page = pageStr == null ? 1 : Integer.parseInt(req.getParameter("current_page"));
        int record = 2;
        int totalRecord = userService.countAll();
        List<User> users = userService.findAll(page, record);
        int totalPage = totalRecord % record == 0 ? totalRecord / record : (totalRecord / record + 1);
        int[] pages = new int[totalPage];
        for (int i = 1; i <= totalPage; i++) {
            pages[i - 1] = i;
        }
        req.setAttribute("dispatcher", "list");
        req.setAttribute("total_page", totalPage);
        req.setAttribute("page_number", pages);
        req.setAttribute("current_page", page);
        req.setAttribute("users", users);
        req.getRequestDispatcher("web/List.jsp").forward(req, resp);
    }

    private void showInsert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Role> roles = roleService.findAll();
        req.setAttribute("roles", roles);
        RequestDispatcher dispatcher = req.getRequestDispatcher("web/Create.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "create":
                createUser(req, resp);
                break;
            case "edit":
                editUser(req, resp);
                break;
            case "list":
                page(req, resp);
                break;
        }
    }

    private void editUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isValid = true;
        String id = req.getParameter("id");
        if (Objects.equals(id, "")) {
            isValid = false;
            req.setAttribute("error_id", "ID cannot be empty");
        }
        String name = req.getParameter("name");
        if (!Validate.isUserName(name)) {
            isValid = false;
            req.setAttribute("error_name", "Name must be more than 1 word and only contain word character");
        }
        String code = req.getParameter("code");
        if (!Validate.isUserCode(code)) {
            isValid = false;
            req.setAttribute("error_code", "Code must be U-XXXX with X is from 0 to 9");
        }
        Date birthday = null;
        try {
            birthday = Validate.stringToDate(req.getParameter("birthday"));
        } catch (ParseException e) {
            isValid = false;
            req.setAttribute("error_birthday", "Wrong format date");
        }
        Date dateRelease = new Date();
        if (isValid) {
            String[] role_arr = req.getParameterValues("role");
            List<Role> roles = new ArrayList<>();
            if (role_arr != null) {
                for (String element : role_arr) {
                    int role_id = Integer.parseInt(element);
                    Role role = roleService.findById(role_id);
                    roles.add(role);
                }
            }
            userService.update(new User(id, name, code, birthday, dateRelease, roles));
            req.getRequestDispatcher("/user?action=list").forward(req, resp);
        } else {
            showEdit(req, resp);
        }
    }

    private void createUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        boolean isValid = true;
        String id = req.getParameter("id");
        if (Objects.equals(id, "")) {
            isValid = false;
            req.setAttribute("error_id", "ID cannot be empty");
        }
        String name = req.getParameter("name");
        if (!Validate.isUserName(name)) {
            isValid = false;
            req.setAttribute("error_name", "Name must be more than 1 word and only contain word character");
        }
        String code = req.getParameter("code");
        if (!Validate.isUserCode(code)) {
            isValid = false;
            req.setAttribute("error_code", "Code must be U-XXXX with X is from 0 to 9");
        }
        Date birthday = null;
        try {
            birthday = Validate.stringToDate(req.getParameter("birthday"));
        } catch (ParseException e) {
            isValid = false;
            req.setAttribute("error_birthday", "Wrong format date");
        }
        Date dateRelease = new Date();
        if (isValid) {
            String[] role_arr = req.getParameterValues("role");
            List<Role> roles = new ArrayList<>();
            if (role_arr != null) {
                for (String element : role_arr) {
                    int role_id = Integer.parseInt(element);
                    Role role = roleService.findById(role_id);
                    roles.add(role);
                }
            }
            userService.add(new User(id, name, code, birthday, dateRelease, roles));
            req.getRequestDispatcher("/user?action=list").forward(req, resp);
        } else {
            showInsert(req, resp);
        }
    }
}
