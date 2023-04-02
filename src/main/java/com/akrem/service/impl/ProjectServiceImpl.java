package com.akrem.service.impl;

import com.akrem.dto.ProjectDTO;
import com.akrem.dto.TaskDTO;
import com.akrem.dto.UserDTO;
import com.akrem.enums.Status;
import com.akrem.service.ProjectService;
import com.akrem.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO,String> implements ProjectService{
    TaskService taskService;


    @Override
    public ProjectDTO save(ProjectDTO object) {
        if(object.getProjectStatus() == null){
            object.setProjectStatus(Status.OPEN);
        }else {
            System.out.println("status is given");
        }
      return   super.save(object.getProjectCode(),object);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findALL();
    }

    @Override
    public ProjectDTO findById(String id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(String id) {
         super.deleteById(id);
    }

    @Override
    public void updateById(ProjectDTO object) {
         object.setProjectStatus(findById(object.getProjectCode()).getProjectStatus());
         super.updateById(object.getProjectCode(),object);
    }


    @Override
    public void complete(String id) {
        map.get(id).setProjectStatus(Status.COMPLETE);
    }

    @Override
    public List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manger) {

        // give all the filed that match the page
        List<ProjectDTO> projectDTOS = findAll().
                stream().
                filter(p->p.getAssignedManager().equals(manger)).map(
                projectDTO-> {
                   List<TaskDTO> taskList = taskService.findTaskByManger(manger);
                    int complete =  (int) taskList.stream().filter(v-> v.getProjectDTO().equals(projectDTO) && v.getTaskStatus() == Status.COMPLETE ).count();
                    int unComplete =(int) taskList.stream().filter(v-> v.getProjectDTO().equals(projectDTO) && v.getTaskStatus() != Status.COMPLETE).count();
                    projectDTO.setUncompletedTaskCounts(unComplete);
                    projectDTO.setCompletedTaskCounts(complete);

                          return projectDTO;
                }).collect(Collectors.toList());



        return projectDTOS;
    }
}
