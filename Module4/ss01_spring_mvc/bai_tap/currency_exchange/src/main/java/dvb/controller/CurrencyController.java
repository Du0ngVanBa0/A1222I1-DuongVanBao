package dvb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @GetMapping("/currency")
    public String exchange(@RequestParam double usd, @RequestParam double rate, Model model) {
        double vnd = usd * rate;
        model.addAttribute("vnd", vnd);
        return "index";
    }
}
