package com.akrem.mapper;


import com.akrem.dto.RoleDTO;
import com.akrem.dto.UserDTO;
import com.akrem.entity.User;
import org.modelmapper.Converter;
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
        UserDTO userDTO = new UserDTO();
        RoleDTO roleDTO = new RoleDTO();
      userDTO.setRoleDTO(roleDTO);
      userDTO.getRoleDTO().setDescription(entity.getRole().getDescription());
      userDTO.getRoleDTO().setId(entity.getId());
      userDTO.setUserName(entity.getUserName());
      userDTO.setFirstName(entity.getFirstName());
      userDTO.setLastName(entity.getLastName());
      userDTO.setGender(entity.getGender());
      userDTO.setPassword(entity.getPassword());
      userDTO.setEnable(entity.isEnabled());
      userDTO.setPhone(entity.getPhone());

       return userDTO;
    }


}
