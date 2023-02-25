package com.akrem.service;

import com.akrem.dto.UserDTO;

import java.util.List;

public interface UserService  extends CrudService<UserDTO , String>{
    List<UserDTO> findManagers();

}
