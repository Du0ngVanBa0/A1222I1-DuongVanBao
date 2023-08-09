package dvb.controler;

import dvb.model.Login;
import dvb.model.User;
import dvb.model.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("/home")
    public String home(Model model, @ModelAttribute("login") Login login ) {
        model.addAttribute( "home", new Login());
        return "home";
    }

    @PostMapping("/login")
    public String login(Model model, @ModelAttribute("login") Login login) {
        User user = UserDao.checkLogin(login);
        if (user == null) {
            return "/error";
        } else {
            model.addAttribute("user", user);
            return "/user";
        }
    }
}
