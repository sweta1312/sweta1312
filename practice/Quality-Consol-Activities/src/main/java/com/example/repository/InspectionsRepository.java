package com.example.repository;

import com.example.model.Inspections;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InspectionsRepository extends JpaRepository<Inspections,Long> {

    Optional<Inspections> findByTicketNo(String ticketNo);

/*    String updateInspectionAssigneeResult(Long id,String result);

    String updateInspectionAssigneeStatus(Long id,String result);*/
}
