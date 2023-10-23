package dvb.demo.controller;

import dvb.demo.entity.Product;
import dvb.demo.entity.ProductType;
import dvb.demo.service.ProductService;
import dvb.demo.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping
    public String showList(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int currentSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage - 1, currentSize);
        Page<Product> productPage = productService.findAllPaging(pageable);
        List<Product> productList = productPage.getContent();
        model.addAttribute("productTypes", productTypeService.findAll());
        model.addAttribute("products", productList);
        model.addAttribute("totalPage", productPage.getTotalPages());
        model.addAttribute("pageNumber", productPage.getNumber());
        model.addAttribute("size", productPage.getSize());
        model.addAttribute("currentPage", productPage.getNumber());
        return "/views/index";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("productTypes", productTypeService.findAll());
        return "/views/create";
    }

    @GetMapping("/search")
    public String showSearch(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("search_inp") String inp, @RequestParam("search_inp_price") Optional<Integer> inp_prices, @RequestParam("search_inp_type") int inp_type_id, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int currentSize = size.orElse(5);
        int inp_price = inp_prices.orElse(0);
        if (inp.trim().equals("")) {
            inp = "dasdjauisjdiasjiodjiojqiojwdiojqwdqmcdca";
        }
        Pageable pageable = PageRequest.of(currentPage - 1, currentSize);
        ProductType productType = productTypeService.findById(inp_type_id).get();
        Page<Product> productPage = productService.search(inp, inp_price, productType, pageable);
        List<Product> productList = productPage.getContent();
        model.addAttribute("searchAttr", inp);
        model.addAttribute("searchAttr_price", inp_price);
        model.addAttribute("searchAttr_type", inp_type_id);
        model.addAttribute("productTypes", productTypeService.findAll());
        model.addAttribute("products", productList);
        model.addAttribute("totalPage", productPage.getTotalPages());
        model.addAttribute("pageNumber", productPage.getNumber());
        model.addAttribute("size", productPage.getSize());
        model.addAttribute("currentPage", productPage.getNumber());
        return "/views/index";
    }

    @PostMapping("/create")
    public String createProduct(RedirectAttributes redirectAttributes, @Valid @ModelAttribute(name = "product") Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("productTypes", productTypeService.findAll());
            return "/views/create";
        }
        product.setStatus("Chờ duyệt");
        productService.save(product);
        redirectAttributes.addFlashAttribute("add", true);
        return "redirect:/product";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam("ids") Optional<Integer[]> idsOp, RedirectAttributes redirectAttributes) {
        if (idsOp.isPresent()) {
            for (int id : idsOp.get()) {
                productService.deleteById(id);
            }
            redirectAttributes.addFlashAttribute("remove", true);
        }
        return "redirect:/product";
    }
}
