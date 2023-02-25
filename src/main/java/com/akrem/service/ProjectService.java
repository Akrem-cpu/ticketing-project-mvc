package com.akrem.service;

import com.akrem.dto.ProjectDTO;

public interface ProjectService extends CrudService<ProjectDTO,String> {

 public void complete(String id);



}
