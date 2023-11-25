package com.akrem.service.impl;

import com.akrem.dto.ProjectDTO;
import com.akrem.entity.Project;
import com.akrem.entity.User;
import com.akrem.enums.Status;
import com.akrem.mapper.ProjectMapper;
import com.akrem.mapper.UserMapper;
import com.akrem.repository.ProjectRepository;
import com.akrem.repository.UserRepository;
import com.akrem.service.ProjectService;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProjectSerivceImp implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ProjectMapper projectMapper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public List<ProjectDTO> findAllProject() {
        return projectRepository.findAll().stream().map(projectMapper::convertToDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void save(ProjectDTO projectDTO) {
        Project project = projectMapper.convertToEntity(projectDTO);
        project.setProjectStatus(Status.OPEN);
        User dbUser = userRepository.findByUserName(project.getAssignedManager().getUserName());
        project.getAssignedManager().setId(dbUser.getId());
        projectRepository.save(project);

    }

    @Override
    public ProjectDTO findById(String code) {
        return projectMapper.convertToDTO(projectRepository.findByProjectCode(code));
    }

    @Override
    @Transactional
    public void updateProject(ProjectDTO projectDTO) {
        Project byProjectCode = projectRepository.findByProjectCode(projectDTO.getProjectCode());
        Project project = projectMapper.convertToEntity(projectDTO);
        if(project.getProjectStatus() == null) {
            System.err.println("null here ");
            project.setProjectStatus(Status.OPEN);}
        project.setId(byProjectCode.getId());
        User dbUser = userRepository.findByUserName(project.getAssignedManager().getUserName());
        project.setAssignedManager(dbUser);
        project.getAssignedManager().setId(dbUser.getId());
        projectRepository.save(project);
    }

    @Override
    public void deletedById(String projectCode) {
       long id = projectRepository.findByProjectCode(projectCode).getId();
       projectRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void complete(String projectCode) {
        Project project = projectRepository.findByProjectCode(projectCode);
        project.setProjectStatus(Status.COMPLETE);
        projectRepository.save(project);

    }
}
