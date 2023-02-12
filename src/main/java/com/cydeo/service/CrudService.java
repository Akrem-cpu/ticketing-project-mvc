package com.cydeo.service;

import com.cydeo.dto.RoleDTO;

import java.util.List;

public interface CrudService<T,ID> {
    T save(T t);
    T findById(T T);
    List<T> findAll();
    boolean delete(T Object);
    boolean deleteById(ID id);


}
