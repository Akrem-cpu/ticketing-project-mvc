package com.akrem.service;

import java.util.List;

public interface CrudService<T,ID> {
    T save(T t);
    List<T> findAll();
    T findById(ID T);
    void deleteById(ID id);


}
