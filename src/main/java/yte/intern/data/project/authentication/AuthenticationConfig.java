package yte.intern.data.project.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import yte.intern.data.project.authentication.repository.UserRepository;


//@Configuration
//@Lazy
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthenticationConfig extends WebSecurityConfigurerAdapter {

    private final UserRepository userRepository;

    public AuthenticationConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService(userRepository);
    }


    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider((AuthenticationProvider) customAuthenticationProvider);
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().permitAll().and().
//                formLogin()
//                .loginPage("/login").permitAll()
//                .and()
//                .csrf().disable();
        super.configure(http);
        http.csrf().disable();
        //   http.exceptionHandling().accessDeniedPage("/403");
    }
}