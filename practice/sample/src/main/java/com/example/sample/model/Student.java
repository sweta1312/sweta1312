package com.example.sample.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_table")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stu_id")
    private Integer id;
    @Column(name = "stu_name")
    private String name;
    @Column(name = "stu_add")
    private String address;
    @Column(name = "stu_email")
    private String email;

    @Column(name = "stu_password")
    private String password;

}
