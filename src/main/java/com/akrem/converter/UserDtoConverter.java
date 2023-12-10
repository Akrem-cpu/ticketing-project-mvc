package com.akrem.converter;

import com.akrem.dto.ProjectDTO;

import com.akrem.dto.UserDTO;
import com.akrem.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class UserDtoConverter implements Converter<String , UserDTO> {

    UserService userService;

    public UserDtoConverter(@Lazy UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDTO convert(String source) {
        if(source == null || source.equals("") || source.equals("0")){
            return null;
        }
        return userService.findByUserName(source);
    }
}
