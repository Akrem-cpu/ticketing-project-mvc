package com.akrem.mapper;


import com.akrem.dto.RoleDTO;
import com.akrem.entity.Role;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    @Autowired
     ModelMapper mapper;
    public Role convertToEntity( RoleDTO dto){
      return  mapper.map(dto , Role.class);
    }

    public RoleDTO convertToDTO(Role entity){
        System.out.println(entity.toString());
        return   mapper.map(entity , RoleDTO.class);
    }
}
