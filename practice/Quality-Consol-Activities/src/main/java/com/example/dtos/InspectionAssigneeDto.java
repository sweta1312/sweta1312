package com.example.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InspectionAssigneeDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String createdOn;

    private String startTime;

    private String endTime;

    private String inspectionNo;

    private Boolean is_necessary;

    private String result;

    private String role;

    private String sequence;

    private String status;

    private String userId;

    private String userName;
}
