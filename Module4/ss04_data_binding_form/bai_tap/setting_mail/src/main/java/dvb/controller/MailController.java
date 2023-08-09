package dvb.controller;

import dvb.model.Mail;
import dvb.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mail")
public class MailController {
    private IMailService mailService;

    @Autowired
    public MailController(IMailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/edit")
    public String displayEditForm(Model model, @RequestParam("id") String id) {
        model.addAttribute("mail", mailService.findByID(id));
        model.addAttribute("languages", getLanguages());
        model.addAttribute("sizes", getSizes());
        return "/edit";
    }

    @PostMapping("/edit")
    public String doEdit(@ModelAttribute("mail") Mail mail) {
        mailService.update(mail);
        return "redirect:/mail";
    }

    @GetMapping("")
    public String displayListForm(Model model) {
        model.addAttribute("mails", mailService.findAll());
        return "/list";
    }

    private List<Integer> getSizes() {
        List<Integer> sizes = new ArrayList<>();
        sizes.add(5);
        sizes.add(10);
        sizes.add(15);
        sizes.add(25);
        sizes.add(50);
        sizes.add(100);
        return sizes;
    }

    private List<String> getLanguages() {
        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        return languages;
    }
}
