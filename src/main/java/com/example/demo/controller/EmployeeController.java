package com.example.demo.controller;

import com.example.demo.domain.Department;
import com.example.demo.domain.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping
    public Page<Employee> getAllEmployee(@PageableDefault(size = 10, sort = "id") Pageable pageable){
        return employeeRepository.findAll(pageable);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        Department d = new Department();
        d.setName("IT");
        departmentRepository.save(d);
        return employeeRepository.save(employee);
    }
}
