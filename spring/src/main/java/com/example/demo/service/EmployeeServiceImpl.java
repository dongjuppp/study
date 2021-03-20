package com.example.demo.service;

import com.example.demo.repository.EmployeeRepository;
import com.example.demo.table.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository){
        this.repository=repository;
    }
    @Override
    public Employee getEmployeeByEmpNo(int empNo) {
        return repository.getEmployeeByEmpNo(empNo);
    }
}
