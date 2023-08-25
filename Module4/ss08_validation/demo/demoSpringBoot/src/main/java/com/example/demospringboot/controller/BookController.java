package com.example.demospringboot.controller;

import com.example.demospringboot.entity.Book;
import com.example.demospringboot.service.BookService;
import com.example.demospringboot.service.CategoryService;
import com.example.demospringboot.utils.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BookValidator bookValidator;

    @GetMapping("/list")
    public String displayBook(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "book/list";
    }

    @GetMapping("/create")
    public String displayCreate(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryService.findAll());
        return "book/create";
    }

    @PostMapping("/create")
    public String createBook(@Validated @ModelAttribute("book") Book book, BindingResult bindingResult,
                             Model model) {
        bookValidator.validate(book, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.findAll());
            return "book/create";
        }
        bookService.create(book);
        return "redirect:/book/list";
    }

    @GetMapping("/listPaging")
    public String displayBookPaging(Model model,
                                    @RequestParam("page")Optional<Integer> page,
                                    @RequestParam("size")Optional<Integer> size,
                                    @RequestParam("sort")Optional<String> sort) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);
        String sortField = sort.orElse("name");
        Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by(sortField).ascending());
        Page<Book> books = bookService.findAll(pageable);
        model.addAttribute("books", books);
        int totalPage = books.getTotalPages();
        if (totalPage > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "book/listPaging";
    }

    @GetMapping("detail")
    public String showDetail(@RequestParam("bookId") Book book, Model model) {
        model.addAttribute("book", book);
        return "book/detail";
    }
}
