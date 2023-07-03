package controller;

import entities.Customer;
import service.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerController", value = "/list")
public class CustomerControllerServlet extends HttpServlet {
    private final CustomerService customerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = customerService.getList();
        request.setAttribute("customerList",customers);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }
}
