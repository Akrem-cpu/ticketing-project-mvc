package com.akrem.converter;

import com.akrem.dto.RoleDTO;
import com.akrem.service.RoleService;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class RoleDTOConverter implements Converter<String , RoleDTO> {

   RoleService roleService;

    public RoleDTOConverter(@Lazy RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public RoleDTO convert(String source) {

        return roleService.findById(Long.parseLong(source));
    }


}
