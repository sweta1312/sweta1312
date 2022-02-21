package com.example.service;

import com.example.constants.Constants;
import com.example.dtos.InspectionsDto;
import com.example.exception.InspectionNotFoundException;
import com.example.model.InspectionAssignee;
import com.example.model.Inspections;
import com.example.repository.InspectionAssigneeRepository;
import com.example.repository.InspectionsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InspectionAssigneeImpl implements InspectionAssigneeService {


    @Autowired
    private InspectionAssigneeRepository inspectionAssigneeRepository;
    @Autowired
    private InspectionsRepository inspectionsRepository;

    @Override
    public String updateInspectionAssignee(InspectionsDto inspectionsDto) throws Exception {
        String inspectionNumber = inspectionsDto.getTicketNo();

        ModelMapper mapper = new ModelMapper();

        if (inspectionNumber != null) {
            Optional<Inspections> existinginspection = inspectionsRepository.findByTicketNo(inspectionNumber);
            if (existinginspection.isPresent() && (!existinginspection.get().getStatus().equalsIgnoreCase(Constants.COMPLETED))) {
                List<InspectionAssignee> assigneeListUpdated = inspectionsDto.getInspectionAssigneesDtos().stream()
                        .map(x -> mapper.map(x, InspectionAssignee.class)).collect(Collectors.toList());

                existinginspection.get().setInspectionassignee(assigneeListUpdated);
                Inspections updatedInspection = existinginspection.get();
                inspectionsRepository.save(updatedInspection);
                return "assignee updated for inspection no" + inspectionNumber;
            } else {
                throw new InspectionNotFoundException("Inspection with inspection no:" + inspectionNumber + "not exist");
            }
        } else {
            throw new Exception("Inspections number is null!");
        }
    }
}
