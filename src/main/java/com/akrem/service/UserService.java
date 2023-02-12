package com.akrem.service;

import com.akrem.dto.UserDTO;

public interface UserService  extends CrudService<UserDTO , String>{
   UserDTO updateById(String id,UserDTO userDTO);

}
