package com.akrem.service.impl;


import com.akrem.dto.ProjectDTO;
import com.akrem.dto.UserDTO;
import com.akrem.entity.Project;
import com.akrem.entity.User;
import com.akrem.mapper.UserMapper;
import com.akrem.repository.UserRepository;
import com.akrem.service.ProjectService;
import com.akrem.service.TaskService;
import com.akrem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    @Autowired
    ProjectService  projectService;
    @Autowired
    TaskService taskService;

    @Autowired
    PasswordEncoder passwordEncoder;


    public UserServiceImpl(@Lazy UserRepository userRepository, @Lazy UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> listAllUsers() {
        List<User> all = userRepository.findAll();
        return all.stream().map(userMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO findByUserName(String userName) {
        User user = userRepository.findByUserName(userName);
        return userMapper.convertToDTO(user);
    }

    @Override
    public void save(UserDTO user) {
        User user1 = userMapper.convertToEntity(user);
        user1.setEnabled(true);
   String password = user1.getPassword().substring(user1.getPassword().indexOf(",")+1).trim();
        user1.setPassword(passwordEncoder.encode(password));
       userRepository.save(user1);

    }

    @Override
    public UserDTO update(UserDTO dto) {

        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        // find current user
        User user1 = userRepository.findByUserName(dto.getUserName());
        //map updated user dto to entity object
        User convertedUser = userMapper.convertToEntity(dto);
        // set id
        convertedUser.setId(user1.getId());
        //save
        userRepository.save(convertedUser);
        return null;
    }

    @Override
    @Transactional
    public void deleteByUserName(String userName) {

        User user = userRepository.findByUserName(userName);
        if(checkIfUserCanBeDeleted(user)) {
            user.setIsDeleted(true);
            user.setUserName(user.getUserName()+"_"+user.getId());
            userRepository.save(user);
        }

    }

    private boolean checkIfUserCanBeDeleted(User user){
        switch (user.getRole().getDescription()){
            case "Manager":
                return projectService.findAllByManger(user).isEmpty();
            case "Employee":
               return taskService.findAllByAssignedEmployee(user).isEmpty();
            default:
                return true;
        }


    }

    @Override
    public List<UserDTO> findUserByRole(Long role) {
     return userRepository.findAllByRole_Id(role).stream().map(userMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(String userName) {
        return userMapper.convertToDTO(userRepository.findByUserName(userName));
    }
}
