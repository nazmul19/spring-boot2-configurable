package com.example.demo.domain;

import com.example.demo.service.FakeService;
import org.springframework.beans.factory.annotation.Configurable;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
@Configurable(preConstruction = true)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SALARY")
    private Integer salary;

//    @Autowired
//    FakeService fakeService;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @PrePersist
    @PreUpdate
    public void preUpsert(){
        System.out.println("************   preUpsert  *******************");
        //System.out.println(fakeService);
        FakeService manualFakeService = new FakeService();
        System.out.println("Now manualFakeService");
        manualFakeService.isDependencyAvailable();

    }
}
