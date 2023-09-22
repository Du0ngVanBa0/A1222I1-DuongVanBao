package dvb.phone_management.controller;

import dvb.phone_management.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {
    @Autowired
    private SmartphoneService smartphoneService;

    @GetMapping
    public String showIndex(Model model) {
        model.addAttribute("smartphones", smartphoneService.findAll());
        return "/list";
    }
}
