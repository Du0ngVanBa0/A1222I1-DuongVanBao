package dvb.controller;

import dvb.entity.Comment;
import dvb.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private ICommentService commentService;

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

    @GetMapping("/like")
    public String like(@RequestParam("id") int id){
        commentService.updateLike(id);
        return "redirect:/comment";
    }
}
