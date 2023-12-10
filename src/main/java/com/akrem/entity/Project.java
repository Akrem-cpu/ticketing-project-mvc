package com.akrem.entity;

import com.akrem.dto.UserDTO;
import com.akrem.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "projects")
@Where(clause = "is_deleted=false")
public class Project  extends BaseEntity{
    private String projectName;
    private String projectCode;

    @ManyToOne(fetch =  FetchType.LAZY)
    private User assignedManager;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private String projectDetail;
    private Status projectStatus;
    private int completedTaskCounts;
    private int uncompletedTaskCounts;

}
