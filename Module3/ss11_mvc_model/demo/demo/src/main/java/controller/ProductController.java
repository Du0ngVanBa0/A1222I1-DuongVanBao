package controller;

import model.Category;
import model.Product;
import service.category.CategoryService;
import service.product.ProductService;

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
    private CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                viewList(req, resp);
                break;
            case "detail":
                viewDetail(req, resp);
                break;
            case "create":
                viewCreate(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
            default:

        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.findById(id);
        productService.delete(product);
        resp.sendRedirect("/product");
    }

    private void viewCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryService.findAll();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/WEB-INF/views/product/create.jsp")
                .forward(req, resp);
    }

    private void viewDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.findById(id);
        req.setAttribute("product", product);
        req.getRequestDispatcher("/WEB-INF/views/product/detail.jsp")
                .forward(req, resp);
    }

    private void viewList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.findAll();
        List<Category> categories = categoryService.findAll();
        req.setAttribute("products", products);
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/WEB-INF/views/product/list.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            resp.sendRedirect("/product?action=list");
            return;
        }

        switch (action) {
            case "create":
                postCreate(req, resp);
                break;
            default:
        }
    }

    private void postCreate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int price = Integer.parseInt(req.getParameter("price"));
        String date = req.getParameter("dateRelease");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dateRelease = null;
        try {
            dateRelease = format.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        Category category = categoryService.findById(categoryId);
        Product product = new Product(id, name, quantity, price, dateRelease, category);
        productService.add(product);
        resp.sendRedirect("/product?action=list");
    }
}
