package com.akrem.mapper;

import com.akrem.dto.TaskDTO;
import com.akrem.dto.UserDTO;
import com.akrem.entity.Task;
import com.akrem.entity.User;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    @Autowired
    ModelMapper mapper;

    public Task convertToEntity(TaskDTO dto){
        return  mapper.map(dto , Task.class);
    }

    public TaskDTO convertToDTO(Task entity){
        return mapper.map(entity, TaskDTO.class);
    }

}
