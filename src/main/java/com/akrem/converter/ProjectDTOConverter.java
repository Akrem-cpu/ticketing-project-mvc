package com.akrem.converter;


import com.akrem.dto.UserDTO;
import com.akrem.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
@AllArgsConstructor
public class ProjectDTOConverter implements Converter<String, UserDTO> {
    UserService userService;
    @Override
    public UserDTO convert(String source) {
        return userService.findByUserName(source);
    }

}
