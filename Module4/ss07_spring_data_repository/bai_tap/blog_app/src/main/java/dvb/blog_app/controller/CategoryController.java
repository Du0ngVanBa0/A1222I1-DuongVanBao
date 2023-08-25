package dvb.blog_app.controller;

import dvb.blog_app.entity.Category;
import dvb.blog_app.repository.CategoryRepository;
import dvb.blog_app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "/views/category/index";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("category",new Category());
        return "/views/category/create";
    }

    @PostMapping("/create")
    public String create(Category category){
        categoryService.create(category);
        return "redirect:/category";
    }

    @GetMapping("/{id}/delete")
    public String showDelete(Model model, @PathVariable("id") int id){
        model.addAttribute("category",categoryService.findByID(id));
        return "/views/category/delete";
    }

    @PostMapping("/delete")
    public String delete(Category category){
        categoryService.deleteByID(category.getCategoryId());
        return "redirect:/category";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(Model model, @PathVariable("id") int id){
        model.addAttribute("category",categoryService.findByID(id));
        return "/views/category/edit";
    }

    @PostMapping("/edit")
    public String edit(Category category){
        categoryService.update(category);
        return "redirect:/category";
    }
}
