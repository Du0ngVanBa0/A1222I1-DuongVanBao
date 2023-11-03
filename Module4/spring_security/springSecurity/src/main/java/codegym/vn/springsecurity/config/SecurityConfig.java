package codegym.vn.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Không cần đăng nhập cũng access được
        http.authorizeRequests().antMatchers("/login", "/account/**", "/logoutSuccess").permitAll();
        // Phân quyền trang nào cho role nào được phép truy cập
        http.authorizeRequests().antMatchers("/user/**").hasRole("USER");
        http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
        // Trang trả về khi vào sai quyền
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/deny");
        http.authorizeRequests().and().formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/doLogin")
                .defaultSuccessUrl("/home")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout().logoutUrl("/logout");
//                .logoutSuccessUrl("/logoutSuccess");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }
}
