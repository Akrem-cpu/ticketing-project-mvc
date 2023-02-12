package com.akrem.service;

import java.util.List;

public interface CrudService<T,ID> {
    T save(T t);
    T findById(T T);
    List<T> findAll();
    void delete(T Object);
    void deleteById(ID id);


}
