package dvb.controller;

import dvb.entity.Blog;
import dvb.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("")
    public String showIndex(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @GetMapping("/{id}/view")
    public String showView(Model model, @PathVariable("id") int id) {
        model.addAttribute("blog", blogService.findById(id));
        return "view";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(Model model, @PathVariable("id") int id) {
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }

    @GetMapping("/{id}/delete")
    public String showDelete(Model model, @PathVariable("id") int id) {
        model.addAttribute("blog", blogService.findById(id));
        return "delete";
    }

    @PostMapping("/create")
    public String create(Blog blog) {
        blogService.create(blog);
        return "redirect:/blog";
    }

    @PostMapping("/delete")
    public String delete(Blog blog) {
        blogService.deleteById(blog.getId());
        return "redirect:/blog";
    }

    @PostMapping("/edit")
    public String edit(Blog blog) {
        blogService.update(blog);
        return "redirect:/blog";
    }
}
