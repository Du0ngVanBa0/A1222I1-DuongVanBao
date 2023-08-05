package dvb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/sandwich")
public class SandwichController {
    @PostMapping("/save")
    public String save(@RequestParam(name = "condiments") Optional<String[]> condiments, Model model) {
        model.addAttribute("selected",condiments.orElse(new String[]{""}));
        return "index";
    }
    @GetMapping("")
    public String show(){
        return "index";
    }
}
