package com.akrem.repository;

import com.akrem.entity.Project;
import com.akrem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;
import java.util.List;


public interface ProjectRepository extends JpaRepository<Project,Long> {

    Project findByProjectCode(String code);
    void deleteById(@NotNull Long id);
    List<Project> findAllByAssignedManager(User assignedManager);




}
