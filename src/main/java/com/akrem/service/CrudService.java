package com.akrem.service;

import com.akrem.dto.UserDTO;

import java.util.List;

public interface CrudService<T,ID> {
    T save(T T);
    List<T> findAll();
    T findById(ID T);
    void updateById(T T);




}
