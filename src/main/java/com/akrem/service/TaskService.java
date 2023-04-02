package com.akrem.service;

import com.akrem.dto.ProjectDTO;
import com.akrem.dto.TaskDTO;
import com.akrem.dto.UserDTO;

import java.util.List;

public interface TaskService extends CrudService<TaskDTO,Long> {

       List<TaskDTO> findTaskByManger(UserDTO manger);

}
