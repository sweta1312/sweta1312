package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="inspection_assignee_table")
public class InspectionAssignee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="assignee_id")
    private Long id;

    @Column(name="assignee_createdOn")
    private String createdOn;

    @Column(name="assignee_startTime")
    private String startTime;

    @Column(name="assignee_endTime")
    private String endTime;

    @Column(name="assignee_inspectionNo")
    private String inspectionNo;

    private Boolean is_necessary;

    @Column(name="assignee_result")
    private String result;

    @Column(name="assignee_role")
    private String role;

    private String sequence;

    @Column(name="assignee_status")
    private String status;

    private String userId;

    private String userName;



}
