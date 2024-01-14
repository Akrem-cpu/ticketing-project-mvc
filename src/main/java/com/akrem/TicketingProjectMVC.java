package com.akrem;

import com.akrem.dto.RoleDTO;
import com.akrem.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TicketingProjectMVC {

    public static void main(String[] args) {
        SpringApplication.run(TicketingProjectMVC.class, args);
    }
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PasswordEncoder passwordENcoder(){
        return new BCryptPasswordEncoder();
    }


}
