package com.mann.model;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author Vladimir Mann
 */
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "department_id" , insertable = false, updatable = false)
    private Integer departmentId;
    @Column(name = "name")
    private String name;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "patronymic_name")
    private String patronymicName;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "salary")
    private Long salary;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "departmentId"))
    private Department department;

    public Employee() {
    }

    public Employee(Integer departmentId, String name, String secondName, String patronymicName, LocalDate dateOfBirth, Long salary) {
        this.departmentId = departmentId;
        this.name = name;
        this.secondName = secondName;
        this.patronymicName = patronymicName;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", departmentId=" + departmentId +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", patronymicName='" + patronymicName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", salary=" + salary +
                '}';
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}