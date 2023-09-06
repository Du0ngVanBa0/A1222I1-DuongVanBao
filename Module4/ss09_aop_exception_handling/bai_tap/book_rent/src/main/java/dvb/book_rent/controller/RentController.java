package dvb.book_rent.controller;

import dvb.book_rent.entity.Book;
import dvb.book_rent.entity.Rent;
import dvb.book_rent.service.BookService;
import dvb.book_rent.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/rent")
public class RentController {
    @Autowired
    private RentService rentService;

    @Autowired
    private BookService bookService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("rent", rentService.findAll());
        return "/rent_list";
    }

    @GetMapping("/create")
    public String showRent(Model model, @RequestParam("id") int id) {
        model.addAttribute("book", bookService.findByID(id));
        return "/rent";
    }

    @GetMapping("/back")
    public String showGiveBack() {
        return "/give_back";
    }

    @PostMapping("/back")
    public String giveBack(RedirectAttributes redirectAttributes, @RequestParam("rent_id") String id) {
        Rent rent = rentService.findByID(id);
        if (rent == null){
            redirectAttributes.addFlashAttribute("error", "Can't find that rent id!");
            return "redirect:/rent/back";
        }
        Book book = rent.getBook();
        book.setQuantity(book.getQuantity() + 1);
        rentService.delete(rent);
        bookService.rent(book);
        redirectAttributes.addFlashAttribute("error", "Give back that book successfully!");
        return "redirect:/book";
    }

    @PostMapping("/create")
    public String rent(Book book, RedirectAttributes redirectAttributes) {
        try {
            book.setQuantity(book.getQuantity() - 1);
            bookService.rent(book);
            String rentCode = getRandomCode();
            rentService.create(new Rent(rentCode, book));
            redirectAttributes.addFlashAttribute("error", "Your rent code is " + rentCode);
            return "redirect:/book";
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error", "Quantity = 0. Can't rent that book");
            return "redirect:/book";
        }
    }

    private String getRandomCode() {
        while (true) {
            long codeDigit = 10000 + Math.round(Math.random() * 89999);
            String code = String.valueOf(codeDigit);
            if (rentService.findByID(String.valueOf(code)) == null) {
                return code;
            }
        }
    }
}
