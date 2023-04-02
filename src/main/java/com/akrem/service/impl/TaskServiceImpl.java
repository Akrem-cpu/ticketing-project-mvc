package com.akrem.service.impl;

import com.akrem.dto.TaskDTO;
import com.akrem.dto.UserDTO;
import com.akrem.enums.Status;
import com.akrem.service.TaskService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class TaskServiceImpl extends AbstractMapService<TaskDTO,Long> implements TaskService {
    @Override
    public TaskDTO save(TaskDTO taskDTO) {
        if(taskDTO.getAssignedDate() == null){
            taskDTO.setAssignedDate(LocalDate.now().minusDays(5));
        }
        if(taskDTO.getId() == null){
            taskDTO.setId(UUID.randomUUID().getLeastSignificantBits());
        }
        if(taskDTO.getTaskStatus() == null){
            taskDTO.setTaskStatus(Status.OPEN);
        }
        return super.save(taskDTO.getId(),taskDTO);
    }

    @Override
    public List<TaskDTO> findAll() {
        return super.findALL();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void updateById(TaskDTO taskDTO) {
        if(taskDTO.getAssignedDate() == null){
            taskDTO.setAssignedDate(LocalDate.now().minusDays(5));
        }
        super.updateById(taskDTO.getId(),taskDTO);
    }

    @Override
    public TaskDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<TaskDTO> findTaskByManger(UserDTO manger) {
        return findALL().stream().filter(p-> p.getProjectDTO().getAssignedManager().getUserName().equals(manger.getUserName())).collect(Collectors.toList());
    }
}
