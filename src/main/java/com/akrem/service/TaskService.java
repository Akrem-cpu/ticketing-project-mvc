package com.akrem.service;

import com.akrem.dto.TaskDTO;
import com.akrem.entity.Task;

import java.util.List;

public interface TaskService {
    List<TaskDTO> findAllTask();
    void save(TaskDTO taskDTO);
    TaskDTO findById(Long id);
    void updateById(TaskDTO taskDTO);
    void deleteById(Long id );

    int totalNonCompletedTask(String projectCode);
    int totalCompletedTask(String projectCode);
}
