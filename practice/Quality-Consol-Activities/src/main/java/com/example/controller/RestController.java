package com.example.controller;

import com.example.dtos.InspectionsDto;
import com.example.service.InspectionAssigneeService;
import com.example.service.InspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value="/inspection",
        produces =APPLICATION_JSON_VALUE)
public class RestController {

    @Autowired
    private InspectionService inspectionService;

    @Autowired
    private InspectionAssigneeService assigneeService;

    //1.save
    @PostMapping(value="/create",consumes = { APPLICATION_JSON_VALUE })
    public ResponseEntity<String> saveInspection(@RequestBody InspectionsDto inspectionsDto)
    {
        String message=null;
        try {
            //save if id not null
            if (inspectionsDto.getId() == null) {
                message = inspectionService.saveInspections(inspectionsDto);

                return new ResponseEntity<String>(message, HttpStatus.OK);
            }
            message = "Id shoud be null";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e ) {
            e.printStackTrace();
            return  new ResponseEntity<>("can not save inspection",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    //2.Read
    @GetMapping(value ="/get", consumes = { MediaType.ALL_VALUE })
    public List<InspectionsDto> getInspection(){
        List<InspectionsDto> inspectionsDtos=null;
        try{
            inspectionsDtos = inspectionService.getAllInspections();

        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
        return inspectionsDtos;
    }
    //3.delete
    @DeleteMapping(value = "/delete/{ticketNo}", consumes = { MediaType.ALL_VALUE })
    public void deleteInspections(@PathVariable("ticketNo") String ticketNo)
    {
        //delete inspection from db
        inspectionService.deleteInspections(ticketNo);
    }

    //4.update
    @PutMapping("/update")
    public ResponseEntity<String> updateInspection(@RequestBody InspectionsDto inspectionsDto) {
        String response="";
        try {
            if (inspectionsDto.getId() !=null) {
                response= inspectionService.updateInspections(inspectionsDto);
                return  ResponseEntity.ok(response);
            }
            return new ResponseEntity<String>("please send id for update",HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            e.printStackTrace();
            response = "inspection with id" + inspectionsDto.getId() + "doesnot exist";
            return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    //Inspection_assignee Re-assign
    @PostMapping("/re-Assign")
    public ResponseEntity<?> reassignAssigneeOfInspection(@RequestBody InspectionsDto inspectionsDto)
    {
        String response="";
        try {
            if (inspectionsDto.getId() !=null) {
                response= assigneeService.updateInspectionAssignee(inspectionsDto);
                return  ResponseEntity.ok(response);
            }
            return new ResponseEntity<>("please send id for update",HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            e.printStackTrace();
            response ="inspection with id"+inspectionsDto.getId()+ "doesnot exist";
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        // return new ResponseEntity(assigneeService.reassignInspectionAssignee(inspectionsDto),HttpStatus.OK);
    }

    @PutMapping("/waiveOff")
    public ResponseEntity<String> updateStatusOfInspection(@RequestBody InspectionsDto inspectionsDto) {
        String response="";
        try {
            if (inspectionsDto.getId() !=null) {
                response= inspectionService.updateResults(inspectionsDto);
                return  ResponseEntity.ok(response);
            }
            return new ResponseEntity<String>("please send id for update result",HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            e.printStackTrace();
            response = "inspection with id" + inspectionsDto.getId() + "doesnot exist";
            return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //save result of inspection if it is pass or fail inspection status should completed
    //waveOff
    @PutMapping("/submit")
    public ResponseEntity<String> updateStatus(@RequestBody InspectionsDto inspectionsDto) {
        String response="";
        try {
            if (inspectionsDto.getId() !=null) {
                response= inspectionService.updateStatus(inspectionsDto);
                return  ResponseEntity.ok(response);
            }
            return new ResponseEntity<String>("please send id for update result",HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            e.printStackTrace();
            response = "inspection with id" + inspectionsDto.getId() + "doesnot exist";
            return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
