package com.example.controller;

import com.example.dao.UserDAO;
import com.example.model.User;
import com.example.model.UserComparator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/users")
public class UserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    static List<User> users;

    static {
        users = new ArrayList<>();
    }

    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "search":
                    listUserCountry(request, response);
                    break;
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                case "sort":
                    sortForm(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void sortForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        users.sort(new UserComparator());
        request.setAttribute("listUser", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void listUserCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        users = userDAO.selectUserByCountry(request.getParameter("kw"));
        System.out.println(request.getParameter("kw"));
        request.setAttribute("listUser", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/user/list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertUser(request, response);
                    break;
                case "edit":
                    updateUser(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        users = userDAO.selectAllUsers();
        request.setAttribute("listUser", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/user/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userDAO.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/user/edit.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User newUser = new User(1, name, email, country);
        userDAO.insertUser(newUser);
//        response.sendRedirect("/users");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/users?action=show");
        dispatcher.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User book = new User(id, name, email, country);
        userDAO.updateUser(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/users?action=show");
        dispatcher.forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.deleteUser(id);

        users = userDAO.selectAllUsers();
        request.setAttribute("listUser", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/users?action=show");
        dispatcher.forward(request, response);
    }
}
