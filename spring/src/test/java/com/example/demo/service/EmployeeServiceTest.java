package com.example.demo.service;

import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.enumType.Gender;
import com.example.demo.table.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @InjectMocks
    EmployeeServiceImpl employeeService;


    @Mock
    EmployeeRepository repository;

    @BeforeEach
    void setup(){
        Employee employee=new Employee();
        employee.setFirstName("first");
        employee.setLastName("last");
        employee.setEmpNo(1);
        employee.setGender(Gender.F);
        given(repository.getEmployeeByEmpNo(1)).willReturn(employee);
    }

    @Test
    void testGetCollectEmployeeSearchedByEmpNo(){
        Employee employee=employeeService.getEmployeeByEmpNo(1);
        assertThat(employee).isNotNull();
        assertThat(employee.getFirstName()).isEqualTo("first");
    }

}
