package codegym.vn.springsecurity.service;

import codegym.vn.springsecurity.entity.Account;
import codegym.vn.springsecurity.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRoleService roleService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.findAccountByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("User " + username + " không tồn tại");
        }

        List<String> roles = roleService.findRoleByUsername(username);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (String role: roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role));
        }
        UserDetails userDetails = new User(username, account.getPassword(), grantedAuthorities);
        return userDetails;
    }
}
