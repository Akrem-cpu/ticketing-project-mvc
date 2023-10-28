package com.akrem.repository;


import com.akrem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User,Long> {


}
