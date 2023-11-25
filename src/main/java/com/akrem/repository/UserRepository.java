package com.akrem.repository;


import com.akrem.entity.Role;
import com.akrem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserName(String username);
    void deleteUserByUserName(String username);
    List<User> findAllByRole_Id(Long id);




}
