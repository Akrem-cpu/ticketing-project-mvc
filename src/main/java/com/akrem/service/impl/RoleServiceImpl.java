package com.akrem.service.impl;


import com.akrem.dto.RoleDTO;
import com.akrem.mapper.RoleMapper;
import com.akrem.repository.RoleRepository;
import com.akrem.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public List<RoleDTO> findAllRole() {
        List<com.akrem.entity.Role> roleList = roleRepository.findAll();
        return roleList.stream().map(roleMapper::convertToDTO).collect(Collectors.toList());

    }

    @Override
    public RoleDTO findById(Long Id) {
        return roleMapper.convertToDTO(roleRepository.findById(Id).get());
    }


}
