package com.akrem.converter;

import com.akrem.dto.ProjectDTO;
import com.akrem.dto.UserDTO;
import com.akrem.service.ProjectService;
import com.akrem.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
@AllArgsConstructor
public class UserDTOConverter implements Converter<String , ProjectDTO> {
    ProjectService userService;
    @Override
    public ProjectDTO convert(String source) {
        return userService.findById(source);
    }
}
