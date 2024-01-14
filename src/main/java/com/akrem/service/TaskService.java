package com.akrem.service;

import com.akrem.dto.ProjectDTO;
import com.akrem.dto.TaskDTO;
import com.akrem.entity.Task;
import com.akrem.entity.User;
import com.akrem.enums.Status;

import java.util.List;

public interface TaskService {
    List<TaskDTO> findAllTask();
    void save(TaskDTO taskDTO);
    TaskDTO findById(Long id);
    void updateById(TaskDTO taskDTO);
    void deleteById(Long id );

    int totalNonCompletedTask(String projectCode);
    int totalCompletedTask(String projectCode);

    void deleteByProjectId(ProjectDTO project);

    void compeleteByProject(ProjectDTO projectDTO);

    List <TaskDTO> listAllTasksByStatusIsNot(Status status);

    void updateStatus(TaskDTO taskDTO);

    List<TaskDTO> listAllTasksByStatus(Status status);

    List<TaskDTO> findAllByAssignedEmployee(User user);
}
