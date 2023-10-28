package com.akrem.service;



import com.akrem.dto.RoleDTO;

import java.util.List;


public interface RoleService {
    List<RoleDTO> findAllRole();
    RoleDTO findById(Long Id);
}
