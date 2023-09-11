package dvb.cart.controller;

import dvb.cart.entity.Cart;
import dvb.cart.entity.Product;
import dvb.cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/shop")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    public Cart init() {
        return new Cart();
    }

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("products", productService.findAll());
        return ("/index");
    }

    @GetMapping("/add/{id}")
    public String addProduct(@PathVariable int id, @SessionAttribute("cart") Cart cart){
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()){
            cart.addProduct(productOptional.get());
        }
        return "redirect:/cart";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id, @SessionAttribute("cart") Cart cart){
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()){
            cart.deleteProduct(productOptional.get());
        }
        return "redirect:/cart";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable int id){
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()){
            model.addAttribute("product",productOptional.get());
        }else {
            model.addAttribute("product", null);
        }
        return "/detail";
    }

    @GetMapping("/change")
    public String changeQuantity(@SessionAttribute("cart") Cart cart, Model model, @RequestParam("id") int id, @RequestParam("newQuantity") int newQuantity){
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()){
            cart.changeQuantity(productOptional.get(), newQuantity);
            model.addAttribute("product",productOptional.get());
        }
        return "redirect:/cart";
    }
}
