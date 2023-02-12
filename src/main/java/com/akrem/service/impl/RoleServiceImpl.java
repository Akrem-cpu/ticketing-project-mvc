package com.akrem.service.impl;

import com.akrem.dto.RoleDTO;
import com.akrem.dto.UserDTO;
import com.akrem.entity.Role;
import com.akrem.service.RoleService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Qualifier("this is the right imp")
public class RoleServiceImpl extends AbstractMapService<RoleDTO, Long> implements RoleService{


    @Override
    public RoleDTO save(RoleDTO roleDTO) {
        return super.save(roleDTO.getId(),roleDTO);
    }

    @Override
    public List<RoleDTO> findAll() {
        return super.findALL();
    }

    @Override
    public void updateById(RoleDTO roleDTO) {
        super.updateById(roleDTO.getId(),roleDTO);
    }

    @Override
    public RoleDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
          super.deleteById(id);
    }




}
