package com.example.dtos;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class  InspectionsDto {
    private Long id;

    private String createdOn;

    private String date;

    private String startTime;

    private String endTime;

    private String keyName;

    private String modifiedOn;

    private String name;

    private String result;

    private String status;

    private String ticketNo;

    private String type;

    private String failQty;

    private String passQty;

    private String gRNNumber;

    private String holdQty;

    private List<InspectionAssigneeDto> inspectionAssigneesDtos;
}
