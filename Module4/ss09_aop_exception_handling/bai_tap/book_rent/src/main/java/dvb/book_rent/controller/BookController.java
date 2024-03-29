package dvb.book_rent.controller;

import dvb.book_rent.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("books", bookService.findAll());
        return "/index";
    }
}
