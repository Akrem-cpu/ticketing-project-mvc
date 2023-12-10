package com.akrem.repository;

import com.akrem.entity.Task;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

    Task findByTaskSubject(String taskSubject);


}
