package com.example.sample.dtos;

import com.example.sample.model.Address;
import com.example.sample.model.DrivingLicence;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private Integer id;

    private String name;

    private String email;

    private List<Address> addresses;

    private DrivingLicence drivingLicence;
}
