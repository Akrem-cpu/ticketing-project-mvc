package com.akrem.service;

import com.akrem.dto.TaskDTO;
import com.akrem.entity.Task;

import java.util.List;

public interface TaskService {
    List<TaskDTO> findAllTask();
    void save(TaskDTO taskDTO);
}
