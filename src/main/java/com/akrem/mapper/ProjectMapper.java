package com.akrem.mapper;

import com.akrem.dto.ProjectDTO;
import com.akrem.entity.Project;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {
    @Autowired
    ModelMapper mapper;
    public Project convertToEntity(ProjectDTO dto){
        return  mapper.map(dto , Project.class);
    }

    public ProjectDTO convertToDTO(Project entity){
        return   mapper.map(entity , ProjectDTO.class);
    }
}
