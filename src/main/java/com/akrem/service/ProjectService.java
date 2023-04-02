package com.akrem.service;

import com.akrem.dto.ProjectDTO;
import com.akrem.dto.UserDTO;

import java.util.List;

public interface ProjectService extends CrudService<ProjectDTO,String> {

 public void complete(String id);

 List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manger);



}
