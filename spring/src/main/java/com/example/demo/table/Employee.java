package com.example.demo.table;

import com.example.demo.repository.enumType.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@Entity(name = "Employees")
public class Employee {
    @Id
    @Column(name = "emp_no")
    private int empNo;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "hire_date")
    private Date hireDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;
}