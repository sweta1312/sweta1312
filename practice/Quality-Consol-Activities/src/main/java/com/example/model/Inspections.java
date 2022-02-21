package com.example.model;

import com.example.dtos.InspectionAssigneeDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="inspections_table")
public class Inspections {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="insp_createdOn")
    private String createdOn;

    @Column(name="insp_date")
    private String date;

    @Column(name="insp_startTime")
    private String startTime;

    @Column(name="insp_endTime")
    private String endTime;

    private String keyName;

    private String modifiedOn;

    private String name;

    @Column(name="insp_result")
    private String result;

    @Column(name="insp_status")
    private String status;

    private String ticketNo;

    private String type;

    private String failQty;

    private String passQty;

    private String gRNNumber;

    private String holdQty;

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="insp_id")
    private List<InspectionAssignee> inspectionassignee;


}
