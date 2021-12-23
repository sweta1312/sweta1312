package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "emptab")
public class Employee {
    @Id
    @Column(name = "emp_id")
    private Integer id;
    @Column(name = "emp_name")
    private String name;
    private String address;

    public Employee() {

    }

    public Employee(Integer id, String name, String address) {
        this.id=id;
        this.name=name;
        this.address=address;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
