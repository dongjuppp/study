package com.example.demo.repository;

import com.example.demo.table.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee getEmployeeByEmpNo(int empNo);
}
