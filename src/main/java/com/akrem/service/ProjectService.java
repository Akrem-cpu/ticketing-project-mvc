package com.akrem.service;

import com.akrem.dto.ProjectDTO;
import com.akrem.dto.UserDTO;

import java.util.List;

public interface ProjectService {
    List<ProjectDTO>findAllProject();
    void save(ProjectDTO projectDTO);
    ProjectDTO findById(String code);
    void updateProject(ProjectDTO projectDTO);
    void deletedById(String projectCode);
    void complete(String projectCode);
    List<ProjectDTO> findAllByManger(UserDTO userDTO);
}
