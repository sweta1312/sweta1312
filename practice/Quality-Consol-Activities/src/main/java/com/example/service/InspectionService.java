package com.example.service;

import com.example.dtos.InspectionsDto;

import java.util.List;

public interface InspectionService {

    String saveInspections(InspectionsDto dto) ;

    List<InspectionsDto> getAllInspections();

    void deleteInspections(String ticketNo);

    String updateInspections(InspectionsDto dto) throws Exception;

    String updateResults(InspectionsDto inspectionsDto);

    String updateStatus(InspectionsDto inspectionsDto);
}
