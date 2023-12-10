package com.akrem.entity;

import com.akrem.dto.ProjectDTO;
import com.akrem.dto.UserDTO;
import com.akrem.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Tasks")
@Where(clause = "is_deleted=false")
public class Task extends BaseEntity {
    @ManyToOne(fetch =  FetchType.LAZY)
    private Project project;
    @ManyToOne(fetch =  FetchType.LAZY)
    private User assignedEmployee;
    private String taskSubject;
    private String taskDetail;
    @Enumerated(EnumType.STRING)
    private Status taskStatus;

    @Column(nullable = false)
    private LocalDate assignedDate;





}
