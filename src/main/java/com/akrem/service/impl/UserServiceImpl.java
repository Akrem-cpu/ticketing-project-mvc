package com.akrem.service.impl;


import com.akrem.dto.UserDTO;
import com.akrem.entity.User;
import com.akrem.mapper.UserMapper;
import com.akrem.repository.UserRepository;
import com.akrem.service.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    UserMapper userMapper;

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
       userRepository.save(userMapper.convertToEntity(user));

    }

    @Override
    public UserDTO update(UserDTO dto) {
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
        user.setIsDeleted(true);
        userRepository.save(user);

    }
}
