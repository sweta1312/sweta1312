package com.asset.assetmanagement.dtos;

import com.asset.assetmanagement.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false,unique=true)
        private String empId;

        private String firstName;

        private String lastName;

        private String address;

        private String email;

        private String mobile;

        private String gender;

        @Column(nullable = false)
        private String status;

        private String designation;

        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @Temporal(TemporalType.DATE)
        private Date dob;

        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @Temporal(TemporalType.DATE)
        private Date doj;

        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @Temporal(TemporalType.DATE)
        private Date doe;


        @OneToMany(
                cascade = CascadeType.ALL,
                fetch = FetchType.EAGER)
        @JoinColumn(name="employee_id_fk")
        private List<Category> categoriesdto;
}
