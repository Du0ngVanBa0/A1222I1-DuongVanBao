package codegym.vn.springsecurity.controller;

import codegym.vn.springsecurity.entity.Account;
import codegym.vn.springsecurity.entity.AccountRole;
import codegym.vn.springsecurity.service.AccountRoleService;
import codegym.vn.springsecurity.service.AccountService;
import codegym.vn.springsecurity.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private AccountRoleService accountRoleService;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("account", new Account());
        return "createAccount";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("account") Account account) {
        account.setPassword(encoder.encode(account.getPassword()));
        accountService.create(account);
        return "home";
    }

    @GetMapping("/addRole")
    public String showAddRole(Model model) {
        model.addAttribute("accountRole", new AccountRole());
        model.addAttribute("accounts", accountService.findAll());
        model.addAttribute("roles", roleService.findAll());
        return "addAccountRole";
    }

    @PostMapping("/addRole")
    public String addRole(@ModelAttribute("accountRole") AccountRole accountRole) {
        accountRoleService.create(accountRole);
        return "home";
    }
}
