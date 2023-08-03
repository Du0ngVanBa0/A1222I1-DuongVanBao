package dvb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculate")
public class CalculatorController {
    @GetMapping("")
    public String showPage() {
        return "index";
    }

    @PostMapping("/result")
    public String showResult(@RequestParam(name = "type") String type, @RequestParam(name = "nb1", required = false) double nb1, @RequestParam(name = "nb2", required = false) double nb2, Model model) {
        double result = 0;
        switch (type) {
            case "addition":
                result = nb1 + nb2;
                break;
            case "subtraction":
                result = nb1 - nb2;
                break;
            case "multiplication":
                result = nb1 * nb2;
                break;
            case "division":
                result = nb1 / nb2;
                break;
        }
        model.addAttribute("result", result);
        return "index";
    }
}
