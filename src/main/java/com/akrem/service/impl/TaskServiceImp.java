package com.akrem.service.impl;

import com.akrem.dto.TaskDTO;
import com.akrem.entity.Task;
import com.akrem.enums.Status;
import com.akrem.mapper.TaskMapper;
import com.akrem.repository.TaskRepository;
import com.akrem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
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
        Task task = taskRepository.findById(taskDTO.getId()).get();
        if(taskDTO.getTaskStatus() == null){
            taskDTO.setTaskStatus(task.getTaskStatus());
        }
        taskDTO.setId(task.getId());
        taskRepository.save(taskMapper.convertToEntity(taskDTO));


    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Task task = taskRepository.getById(id);
        task.setIsDeleted(true);
        taskRepository.save(task);

    }
}
