package controller;

import model.Product;
import servirce.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ProductController", value = "/product")
public class ProductController extends HttpServlet {
    private ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "list":
                getList(request, response);
                break;
            case "create":
                getCreate(request, response);
                break;
            case "delete":
                getDelete(request, response);
                break;
            case "update":
                getUpdate(request, response);
                break;
            default:
        }
    }

    private void getUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = productService.findByID(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("product", product);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = simpleDateFormat.format(product.getDateRelease());
        request.setAttribute("dateRelease", dateString);
        request.getRequestDispatcher("WEB-INF/views/update.jsp").forward(request, response);
    }

    private void getDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.findAll();
        request.setAttribute("products", products);
        request.getRequestDispatcher("WEB-INF/views/delete.jsp").forward(request, response);
    }

    private void getCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/create.jsp").forward(request, response);
    }

    private void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.findAll();
        request.setAttribute("products", products);
        request.getRequestDispatcher("WEB-INF/views/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "create":
                postCreate(request, response);
                break;
            case "delete":
                postDelete(request, response);
                break;
            default:
        }
    }

    private void postDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.delete(productService.findByID(id));
        response.sendRedirect("/product");
    }

    private void postCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        long price = Long.parseLong(request.getParameter("price"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateRelease = null;
        try {
            dateRelease = simpleDateFormat.parse(request.getParameter("dateRelease"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Product product = new Product(id, name, quantity, price, dateRelease);
        productService.add(product);
        response.sendRedirect("/product");
    }
}
