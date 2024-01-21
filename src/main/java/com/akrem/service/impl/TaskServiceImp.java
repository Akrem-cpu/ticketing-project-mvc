package com.akrem.service.impl;

import com.akrem.dto.ProjectDTO;
import com.akrem.dto.TaskDTO;
import com.akrem.entity.Project;
import com.akrem.entity.Task;
import com.akrem.entity.User;
import com.akrem.enums.Status;
import com.akrem.mapper.ProjectMapper;
import com.akrem.mapper.TaskMapper;
import com.akrem.mapper.UserMapper;
import com.akrem.repository.TaskRepository;
import com.akrem.service.TaskService;
import com.akrem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImp implements TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    ProjectMapper projectMapper;

    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;

    @Override
    public List<TaskDTO> findAllTask() {
        return taskRepository.findAll().stream().map(taskMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public void save(TaskDTO taskDTO) {
        if(taskDTO.getTaskStatus() == null) taskDTO.setTaskStatus(Status.OPEN);
        if(taskDTO.getAssignedDate() == null) taskDTO.setAssignedDate(LocalDate.now());
        taskRepository.save(taskMapper.convertToEntity(taskDTO));
    }

    @Override
    public TaskDTO findById(Long id) {
        return  taskMapper.convertToDTO(taskRepository.getById(id));
    }

    @Override
    @Transactional
    public void updateById(TaskDTO taskDTO) {
        Optional<Task> task = taskRepository.findById(taskDTO.getId());
        Task convertedTask = taskMapper.convertToEntity(taskDTO);

        task.ifPresent(value -> {
            convertedTask.setId(value.getId());
            if(convertedTask.getTaskStatus() == null){
                convertedTask.setTaskStatus(value.getTaskStatus());
            }
            convertedTask.setAssignedDate(value.getAssignedDate());
        });
        taskRepository.saveAndFlush(convertedTask);



    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Task task = taskRepository.getById(id);
        task.setIsDeleted(true);
        taskRepository.save(task);

    }

    @Override
    public int totalNonCompletedTask(String projectCode) {
        return taskRepository.totalNonCompletedTasks(projectCode);
    }

    @Override
    public int totalCompletedTask(String projectCode) {
        return taskRepository.totalCompletedTasks(projectCode);
    }

    @Override
    @Transactional
    public void deleteByProjectId(ProjectDTO projectDTO) {
        taskRepository.getTaskByProject(projectMapper.convertToEntity(projectDTO)).forEach(t-> deleteById(t.getId()));
    }

    @Override
    public void compeleteByProject(ProjectDTO projectDTO) {
        taskRepository.getTaskByProject(projectMapper.convertToEntity(projectDTO)).
                forEach(t-> {t.setTaskStatus(Status.COMPLETE); save(taskMapper.convertToDTO(t));});

    }

    @Override
    public List<TaskDTO> listAllTasksByStatusIsNot(Status status) {
        User loggedInUser = userMapper.convertToEntity(userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()));
        return taskRepository.getAllByTaskStatusIsNotAndAssignedEmployee(status,loggedInUser).stream().map(taskMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public void updateStatus(TaskDTO taskDTO) {
        Task task = taskRepository.getById(taskDTO.getId());
        Task convertedTask = taskMapper.convertToEntity(taskDTO);
        convertedTask.setId(task.getId());
        task.setTaskStatus(taskDTO.getTaskStatus());
        convertedTask.setAssignedDate(task.getAssignedDate());
        taskRepository.save(task);
    }

    @Override
    public List<TaskDTO> listAllTasksByStatus(Status status) {
        User loggedInUser = userMapper.convertToEntity(userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()));
        return taskRepository.getAllByTaskStatusIsAndAssignedEmployee(status,loggedInUser).stream().map(taskMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> findAllByAssignedEmployee(User user) {

        return taskRepository.getAllByAssignedEmployee(user).stream().map(taskMapper::convertToDTO).collect(Collectors.toList());
    }


}
