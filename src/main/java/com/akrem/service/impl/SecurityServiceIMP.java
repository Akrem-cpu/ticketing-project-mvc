package com.akrem.service.impl;

import com.akrem.entity.User;
import com.akrem.entity.common.UserPrincipal;
import com.akrem.repository.UserRepository;
import com.akrem.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceIMP implements SecurityService {
    @Autowired
    private  UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUserName(username);
        if(username == null){
            throw  new UsernameNotFoundException("this user does not exits");

        }
        return new UserPrincipal(user);
    }
}
