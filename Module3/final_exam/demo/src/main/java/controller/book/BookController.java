package controller.book;

import model.Book;
import model.Rent;
import model.Student;
import service.impl.BookServiceImpl;
import service.impl.RentServiceImpl;
import service.impl.StudentServiceImpl;
import util.Validate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "BookController", value = "/book")
public class BookController extends HttpServlet {
    private BookServiceImpl bookService = new BookServiceImpl();
    private StudentServiceImpl studentService = new StudentServiceImpl();
    private RentServiceImpl rentService = new RentServiceImpl();

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
            case "rent":
                showRentPage(request, response);
                break;
        }
    }

    private void showRentPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book rent_book = bookService.findByID(request.getParameter("id"));
        List<Student> studentList = studentService.findAll();
        request.setAttribute("this_book", rent_book);
        request.setAttribute("this_date", new Date());
        request.setAttribute("student_list", studentList);
        request.getRequestDispatcher("/views/book/rent.jsp").forward(request, response);
    }

    private void showPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> bookList = bookService.findAll();
        request.setAttribute("books", bookList);
        request.getRequestDispatcher("/views/book/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "list":
                showPage(request, response);
                break;
            case "rent":
                doRent(request, response);
                break;
        }
    }

    private void doRent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isValid = true;
        String name = request.getParameter("name");
        Date rent_date = new Date();
        Date back_date = null;
        try {
            back_date = Validate.stringToDate(request.getParameter("back_date"));
        } catch (ParseException e) {
            isValid = false;
            request.setAttribute("errorDate", "Sai định dạng ngày");
        }
        if (isValid && !Validate.checkBackDate(rent_date, back_date)) {
            isValid = false;
            request.setAttribute("errorDate", "Ngày trả phải sau ngày thuê");
        }
        if (isValid) {
            String book_id = request.getParameter("id");
            Book book = bookService.findByID(book_id);
            int student_id = Integer.parseInt(request.getParameter("student"));
            Student student = studentService.findByID(student_id);
            Rent rent = new Rent(book, student, true, rent_date, back_date);
            rentService.add(rent);
        } else {
            showRentPage(request, response);
        }
    }
}
