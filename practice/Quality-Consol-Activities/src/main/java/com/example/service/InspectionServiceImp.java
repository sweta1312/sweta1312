package com.example.service;

import com.example.constants.Constants;
import com.example.dtos.InspectionAssigneeDto;
import com.example.dtos.InspectionsDto;
import com.example.exception.InspectionNotFoundException;
import com.example.model.InspectionAssignee;
import com.example.model.Inspections;
import com.example.repository.InspectionAssigneeRepository;
import com.example.repository.InspectionsRepository;
import lombok.Builder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InspectionServiceImp implements InspectionService {


    @Autowired
    private InspectionsRepository inspectionsRepository;

    @Autowired
    private InspectionAssigneeRepository inspectionAssigneeRepository;

    @Override
    public String saveInspections(InspectionsDto dto) {
        dto.setTicketNo(generateTicketNo());
        ModelMapper mapper = new ModelMapper();
        //convert dto to entity
        Inspections toSave = mapper.map(dto,Inspections.class);
        List<InspectionAssignee> assigneesList = dto.getInspectionAssigneesDtos().stream()
                .map(x->mapper.map(x,InspectionAssignee.class)).collect(Collectors.toList());

        toSave.setInspectionassignee(assigneesList);

        toSave.getInspectionassignee().forEach(x->x.setInspectionNo(dto.getTicketNo()));
        // Save inspection
        Inspections savedinspection = inspectionsRepository.save(toSave);

        return "Inspection with inspection number " + savedinspection.getTicketNo() +  " saved ";
    }

    @Override
    public List<InspectionsDto> getAllInspections() {
        ModelMapper mapper = new ModelMapper();
        List<Inspections> inspectionsList = inspectionsRepository.findAll();
        List<InspectionsDto> inspectionsDList=new ArrayList<>();
        for (Inspections inspections:inspectionsList)
        {
            InspectionsDto dto = mapper.map(inspections, InspectionsDto.class);

            List<InspectionAssigneeDto> assignees=inspections.getInspectionassignee()
                    .stream().map(x->mapper.map(x, InspectionAssigneeDto.class)).collect(Collectors.toList());
            dto.setInspectionAssigneesDtos(assignees);
            inspectionsDList.add(dto);
        }
        return inspectionsDList;
    }
    @Override
    public void deleteInspections(String ticketNo) {
        //check whether exit or not
        Optional<Inspections> exist = inspectionsRepository.findByTicketNo(ticketNo);
        if (exist.isPresent()) {
            inspectionsRepository.deleteById(exist.get().getId());
        }
        else throw new InspectionNotFoundException("Inspecgtion with id " + ticketNo + " doesnt exist");

    }


    @Override
    public String updateInspections(InspectionsDto dto)  {
        Optional<Inspections> existinginspection = inspectionsRepository.findById(dto.getId());
     /*   InspectionsDto dto1 = dto.builder().id(existinginspection.get().getId())
                .createdOn("12/02/2022")
                .date(existinginspection.get().getDate())
                .build();*/

        String message="";
        //if present inspection then update
        if (existinginspection.isPresent())
        {
            ModelMapper mapper = new ModelMapper();

            Inspections tosave = mapper.map(dto, Inspections.class);
            List<InspectionAssignee> assigneeList = dto.getInspectionAssigneesDtos().stream()
                    .map(x -> mapper.map(x, InspectionAssignee.class)).collect(Collectors.toList());
            tosave.setInspectionassignee(assigneeList);
            Inspections savedinspection = inspectionsRepository.save(tosave);
            message="Inspection with" +dto.getId()+"updated successfully";

        }
        else
        {
            message="Inspection with" +dto.getId()+"not exist";
        }
        return message;
    }


    @Override
    public String updateResults(InspectionsDto inspectionsDto) {
        Optional<Inspections> exist = inspectionsRepository.findById(inspectionsDto.getId());
        String message="";
        //check wether present or not and result is waiveOff
        if(exist.isPresent() && (exist.get().getResult().equalsIgnoreCase(Constants.WAIVE_OFF)))
        {
            ModelMapper mapper=new ModelMapper();
            inspectionsDto.setStatus(Constants.COMPLETED);

            Inspections tosave = mapper.map(inspectionsDto, Inspections.class);
            tosave.setEndTime(LocalDateTime.now().toString());
            List<InspectionAssignee> assigneeList = inspectionsDto.getInspectionAssigneesDtos().stream()
                    .map(x -> mapper.map(x, InspectionAssignee.class)).collect(Collectors.toList());
            tosave.setInspectionassignee(assigneeList);
            tosave.getInspectionassignee().forEach(x->x.setStatus(Constants.COMPLETED));
            //save now
            Inspections savedstatus = inspectionsRepository.save(tosave);
            message= "Inspection with" +savedstatus.getId()+ "status updated";
           /* exist.get().setInspectionassignee(assigneeList);
            exist.get().setStatus(Constants.COMPLETED);
            */
        }
        else
        {
            message="Inspection with" +inspectionsDto.getId()+"not exist";
        }
        return message;
    }

  //submit
    @Override
    public String updateStatus(InspectionsDto inspectionsDto) {
        Optional<Inspections> exist = inspectionsRepository.findById(inspectionsDto.getId());
       /* Inspections ins=Inspections.builder().inspectionassignee().build();
        InspectionAssignee assignee = InspectionAssignee.builder().status(AssigneeStatus.RE_ASSIGN).build();*/
        String message="";
        //check wether present or not and if result equals to pass and fail then status should completed
        if(exist.isPresent() && (!exist.get().getResult().equalsIgnoreCase(Constants.WAIVE_OFF)))
        {
            ModelMapper mapper=new ModelMapper();

            inspectionsDto.setStatus(Constants.COMPLETED);
            Inspections tosave = mapper.map(inspectionsDto, Inspections.class);
            tosave.setEndTime(LocalDateTime.now().toString());
            List<InspectionAssignee> assigneeList = inspectionsDto.getInspectionAssigneesDtos().stream()
                    .map(x -> mapper.map(x, InspectionAssignee.class)).collect(Collectors.toList());
            tosave.setInspectionassignee(assigneeList);
            tosave.getInspectionassignee().forEach(x->x.setStatus(Constants.COMPLETED));
            //save now
            Inspections savedstatus = inspectionsRepository.save(tosave);
            message= "Inspection with" +savedstatus.getId()+ "status updated";

        }
        else
        {
            message="Inspection with" +inspectionsDto.getId()+"not exist";
        }
        return message;
    }

    private static String generateTicketNo() {
        String otp = "";
        for (int i = 1; i <= 5; i++) {
            otp = otp+(int)( Math.random()*10);
        }
        Date localDateTime ;
        return "IN"+LocalDate.now().getDayOfYear()+LocalDate.now().getMonthValue()+LocalDate.now().getYear()+ otp;

    }
/*
    private static Long findDifference(String endTime,String startTime) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Time t1 = null;
        Time t2 = null;
        long totalTime  = 0;
        try {
            t1 = (Time) format.parse(endTime);
            t2 = (Time) format.parse(startTime);
            totalTime = t1.getTime() - t2.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalTime ;
    }*/



}
