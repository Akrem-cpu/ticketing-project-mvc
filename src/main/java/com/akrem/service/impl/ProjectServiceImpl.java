package com.akrem.service.impl;

import com.akrem.dto.ProjectDTO;
import com.akrem.enums.Status;
import com.akrem.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO,String> implements ProjectService{
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
        super.updateById(object.getProjectCode(),object);
    }



}
