package com.example.demo;

import com.example.demo.service.EmployeeService;
import com.example.demo.table.Employee;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AppRunner implements ApplicationRunner {
    private EmployeeService service;
    public AppRunner(EmployeeService service){
        this.service=service;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println("사원 번호를 입력하세요!");
            int empNo=scanner.nextInt();

            Employee employee=service.getEmployeeByEmpNo(empNo);

            if(employee==null){
                System.out.println("없는 사원 입니다");
                break;
            }

            System.out.println(String.format("사원번호: %d, 사원이름: %s",employee.getEmpNo(),employee.getLastName()+employee.getFirstName()));
        }
    }
}
