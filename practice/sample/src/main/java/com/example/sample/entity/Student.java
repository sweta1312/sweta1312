package com.example.sample.entity;


        import javax.persistence.Column;
        import javax.persistence.Entity;
        import javax.persistence.Id;
        import javax.persistence.Table;

@Entity
@Table(name = "stu_table")
public class Student {
    @Id
    @Column(name = "stu_id")
    private Integer id;
    @Column(name = "stu_name")
    private String name;
    private String address;

    public Student() {

    }

    public Student(Integer id, String name, String address) {
        this.id=id;
        this.name=name;
        this.address=address;
    }

    public Student(String name, String address) {
        this.name = name;
        this.address = address;
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
