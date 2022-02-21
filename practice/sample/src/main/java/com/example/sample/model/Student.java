package com.example.sample.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_table")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "stu_name")
    private String name;

    @Column(name = "stu_email")
    private String email;

    @Column(name = "stu_password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    //while fetching parent child should also extracted
    @JoinColumn(name="sa_fk")
    private List<Address> addresses;

    @OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="sdl_fk")
    private DrivingLicence drivingLicence;

}
