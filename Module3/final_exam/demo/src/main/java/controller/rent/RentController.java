package controller.rent;

import model.Rent;
import service.impl.RentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RentController", value = "/rent")
public class RentController extends HttpServlet {
    RentServiceImpl rentService = new RentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "list":
                showPage(request, response);
                break;
        }
    }

    private void showPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Rent> rents = rentService.findAll();
        request.setAttribute("rents", rents);
        request.getRequestDispatcher("/views/rent/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
