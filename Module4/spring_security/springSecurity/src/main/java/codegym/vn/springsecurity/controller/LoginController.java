package codegym.vn.springsecurity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/deny")
    public String deny() {
        return "accessDenied";
    }

//    @GetMapping("/logoutSuccess")
//    public String logout() {
//        return "logout";
//    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "logout";
    }

    @GetMapping("/user/home")
    public String user() {
        return "user";
    }
    @GetMapping("/admin/home")
    public String admin() {
        return "admin";
    }
}
