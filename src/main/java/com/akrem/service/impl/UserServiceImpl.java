package com.akrem.service.impl;

import com.akrem.dto.UserDTO;
import com.akrem.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl extends AbstractMapService<UserDTO,String> implements UserService {

    @Override
    public UserDTO save(UserDTO userDTO) {
        return super.save(userDTO.getUserName(),userDTO);
    }

    @Override
    public List<UserDTO> findAll() {
        return super.findALL();
    }

    @Override
    public void updateById(UserDTO userDTO) {
        super.updateById(userDTO.getUserName(),userDTO);
    }

    @Override
    public UserDTO findById(String id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(String id) {
       super.deleteById(id);
    }

 }

