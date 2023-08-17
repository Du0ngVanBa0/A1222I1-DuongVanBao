package dvb.controller;

import dvb.entity.Comment;
import dvb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comment")
public class CommentController {
    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("comment", new Comment());
        model.addAttribute("comments", commentService.findAll());
        return "/index";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("comment") Comment comment) {
        commentService.save(comment);
        return "redirect:/comment";
    }
}
