package com.akrem.config;

import com.akrem.dto.UserDTO;
import com.akrem.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class SecurityConfig {

    @Autowired
    SecurityService securityService;
    @Autowired
    AuthSuccessHandler authSuccessHandler;
//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//        List<UserDetails> userDetails = new ArrayList<>();
//        userDetails.add(new User("Mike", encoder.encode("password"), List.of(new SimpleGrantedAuthority("ROLE_ADMIN"))));
//        userDetails.add(new User("Ozzy", encoder.encode("password"), List.of(new SimpleGrantedAuthority("ROLE_MANAGER"))));
//
//        return new InMemoryUserDetailsManager(userDetails);
//
//    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity.authorizeRequests().
                antMatchers("/user/**").hasAuthority("Admin").
                antMatchers("/project/**").hasAuthority("Manager").
                antMatchers("/task/employee/**").hasAuthority("Employee").
                antMatchers("/task/**").hasAuthority("Manager").
//        antMatchers("/task/**").hasAnyRole("EMPLOYEE","ADMIN").
                // has role always ADD Role_
//        antMatchers("/task/**").hasAnyAuthority("ROLE_EMPLOYEE").
        antMatchers("/",
        "login",
        "/fragments/**"
        , "/assets/**",
        "/images/**").permitAll().anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(authSuccessHandler)
                .failureForwardUrl("/login?error=true")
                .permitAll().
                and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .and()
                .rememberMe()
                .tokenValiditySeconds(120)
                .key("akrem")
                .userDetailsService(securityService)
                .and().build();
        //.httpBasic().and().build();

    }


}
