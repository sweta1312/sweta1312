package com.example.repository;

import com.example.dtos.InspectionAssigneeDto;
import com.example.dtos.InspectionsDto;
import com.example.model.InspectionAssignee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InspectionAssigneeRepository extends JpaRepository<InspectionAssignee,Long> {


/*    @Query(value = "SELECT inspections_table.id, inspection_assignee_table.insp_id " +
            "from inspections_table inner join inspection_assignee_table " +
            "on inspections_table.id=inspection_assignee_table.insp_id ", nativeQuery = true)*/
  /*  @Query(value ="select a from inspection_assignee_table where a.insp_id in (select id from  a.inspections_table where a.id=:id", nativeQuery = true)
    List<InspectionAssignee> fetchAssigneeByInspection(Long id);*/
}