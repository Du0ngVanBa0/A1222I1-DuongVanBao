package dvb.cart.controller;

import dvb.cart.entity.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {
    @GetMapping
    public String showList(Model model, @SessionAttribute(value = "cart", required = false) Cart cart){
        model.addAttribute("cart", cart);
        return  "/cart_list";
    }
}
