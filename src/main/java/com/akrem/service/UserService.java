package com.akrem.service;



import com.akrem.dto.UserDTO;

import java.util.List;

public interface UserService {

  List<UserDTO> listAllUsers();
  UserDTO findByUserName(String userName);
  void save(UserDTO user);
  UserDTO update(UserDTO user);
  void  deleteByUserName(String userName);

}
