package com.akrem.dto;

import com.akrem.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.Manager;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectDTO {
    private Long id;
    private String projectName;
    private String projectCode;
    private UserDTO assignedManager;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private String projectDetail;
    @Enumerated(EnumType.STRING)
    private Status projectStatus;
    private int completedTaskCounts;
    private int uncompletedTaskCounts;

    public ProjectDTO(String projectName, String projectCode, UserDTO assignedManager, LocalDate startDate, LocalDate endDate, String projectDetail, Status projectStatus) {
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.assignedManager = assignedManager;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectDetail = projectDetail;
        this.projectStatus = projectStatus;
    }
}
