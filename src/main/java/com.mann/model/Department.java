package com.mann.model;


import jdk.nashorn.internal.objects.annotations.Getter;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.CascadeType.REMOVE;

/**
 * @author Vladimir Mann
 */

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "departament_name")
    private String departmentName;

    @OneToMany(fetch = FetchType.EAGER ,mappedBy="department", cascade = REMOVE )
    private Set<Employee> employee;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department() {
    }

    public Department(Integer id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
