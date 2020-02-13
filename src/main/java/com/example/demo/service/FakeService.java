package com.example.demo.service;

import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable(autowire = Autowire.BY_TYPE, preConstruction = true)
public class FakeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void isDependencyAvailable(){
        System.out.println(employeeRepository);
    }
}
