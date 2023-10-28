package com.akrem.mapper;


import com.akrem.dto.UserDTO;
import com.akrem.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    ModelMapper mapper;

    public User convertToEntity(UserDTO dto){
        return  mapper.map(dto , User.class);
    }

    public UserDTO convertToDTO(User entity){
        return   mapper.map(entity , UserDTO.class);
    }


}
