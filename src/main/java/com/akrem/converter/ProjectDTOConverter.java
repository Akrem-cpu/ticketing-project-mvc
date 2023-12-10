package com.akrem.converter;


import com.akrem.dto.ProjectDTO;
import com.akrem.dto.UserDTO;
import com.akrem.repository.ProjectRepository;
import com.akrem.service.ProjectService;
import com.akrem.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
@ConfigurationPropertiesBinding
public class ProjectDTOConverter implements Converter<String, ProjectDTO> {
    ProjectService projectService;

    public ProjectDTOConverter(@Lazy ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public ProjectDTO convert(String source) {
        if(source == null || source.equals("")){
            return null;
        }

        return projectService.findById(source);
    }

}
