package com.example.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


public class Student {
   private String name;
   private Integer age;

   private List<String> contactNo = new ArrayList<>();

   public Student(String name, Integer age, List<String> contactNo) {
      this.name = name;
      this.age = age;
      this.contactNo = contactNo;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Integer getAge() {
      return age;
   }

   public void setAge(Integer age) {
      this.age = age;
   }

   public List<String> getContactNo() {
      return contactNo;
   }

   public void setContactNo(List<String> contactNo) {
      this.contactNo = contactNo;
   }
}