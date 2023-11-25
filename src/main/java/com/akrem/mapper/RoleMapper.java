package com.akrem.mapper;


import com.akrem.dto.RoleDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    @Autowired
     ModelMapper mapper;
    public com.akrem.entity.Role convertToEntity(RoleDTO dto){
      return  mapper.map(dto , com.akrem.entity.Role.class);
    }

    public RoleDTO convertToDTO(com.akrem.entity.Role entity){
        System.out.println(entity.toString());
        return   mapper.map(entity , RoleDTO.class);
    }
}
