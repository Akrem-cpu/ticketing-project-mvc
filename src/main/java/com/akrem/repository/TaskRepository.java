package com.akrem.repository;

import com.akrem.entity.Project;
import com.akrem.entity.Task;
import com.akrem.entity.User;
import com.akrem.enums.Status;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

    @Query("SELECT COUNT(t) FROM Task t WHERE t.project.projectCode = ?1 AND t.taskStatus <> 'COMPLETE' ")
    int totalNonCompletedTasks(String projectCode);

    @Query(value = "SELECT COUNT(*)" +
            "FROM tasks t JOIN projects p on t.project_id = p.id " +
            "WHERE p.project_code = ?1 AND t.task_status = 'COMPLETE'",nativeQuery = true)
    int totalCompletedTasks(String projectCode);

    List<Task> getTaskByProject(Project project);

    List<Task> getAllByTaskStatusIsNotAndAssignedEmployee(Status status, User user);

    List<Task> getAllByTaskStatusIsAndAssignedEmployee(Status status,User user);

    List<Task> getAllByAssignedEmployee(User user);


}
