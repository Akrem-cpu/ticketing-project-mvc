package com.akrem.service.impl;

import com.akrem.dto.TaskDTO;
import com.akrem.enums.Status;
import com.akrem.mapper.TaskMapper;
import com.akrem.repository.TaskRepository;
import com.akrem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImp implements TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TaskMapper taskMapper;


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
}
