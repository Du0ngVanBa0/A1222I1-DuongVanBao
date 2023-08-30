package dvb.blog_app.controller;

import dvb.blog_app.entity.Blog;
import dvb.blog_app.service.BlogService;
import dvb.blog_app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String showIndex(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "/views/blog/paging";
    }

    @GetMapping("/searchCategory")
    public String showCategoryList(Model model, @RequestParam("cateID") int id) {
        model.addAttribute("blogs", blogService.findByCategory(id));
        model.addAttribute("categories", categoryService.findAll());
        return "/views/blog/paging";
    }

    @GetMapping("/search")
    public String showSearch(Model model, @RequestParam("search_inp") String inp) {
        model.addAttribute("blogs", blogService.findByHead(inp));
        return "/views/blog/paging";
    }

    @GetMapping("/sort")
    public String showSortIndex(Model model) {
        model.addAttribute("blogs", blogService.findAllSort());
        return "/views/blog/paging";
    }


    @GetMapping("/paging")
    public String showPaging(Model model,
                             @RequestParam("page") Optional<Integer> page,
                             @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int sizePage = size.orElse(4);
        Pageable pageable = PageRequest.of(currentPage - 1, sizePage);
        Page<Blog> blogs = blogService.findAll(pageable);
        int totalPage = blogs.getTotalPages();
        if (totalPage > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("blogs", blogs);
        return "/views/blog/paging";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.findAll());
        return "/views/blog/create";
    }

    @GetMapping("/{id}/view")
    public String showView(Model model, @PathVariable("id") int id) {
        model.addAttribute("blog", blogService.findById(id));
        return "/views/blog/view";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(Model model, @PathVariable("id") int id) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categories", categoryService.findAll());
        return "/views/blog/edit";
    }

    @GetMapping("/{id}/delete")
    public String showDelete(Model model, @PathVariable("id") int id) {
        model.addAttribute("blog", blogService.findById(id));
        return "/views/blog/delete";
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
