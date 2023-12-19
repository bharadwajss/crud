package com.ibm.crud.repository;

import com.ibm.crud.entity.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest//if relational DB e.g mysql // @DataMongoTest  for mongodb
class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository repository;
    Employee employee;
    @BeforeEach //this it calls at every method call for allocation
    void setUp() {
          employee = Employee.builder().employeeId(1)
                .employeeName("Amit").
                designation("Manager").salary(450000).build();
        repository.save(employee);
    }

    @AfterEach// after deallocation
    void tearDown() {
        employee=null;
        repository.deleteAll();
    }

    @Test
    @DisplayName("This method will test findByEmployeeName() method")
    void testFindByEmployeeName(){
        Employee employee1= repository.findByEmployeeName("Amit");
        Assertions.assertThat(employee1.getEmployeeId()).isEqualTo(1);
        Assertions.assertThat(employee1.getDesignation()).isEqualTo("Manager");
        Assertions.assertThat(employee1.getSalary()).isEqualTo(450000);

    }

    @Test
    void testFindByEmployeeIdMethod(){
        employee = Employee.builder().employeeId(1)
                .employeeName("Amit").
                designation("Manager").salary(450000).build();
       Employee employee1= repository.save(employee);
        Assertions.assertThat(employee1.getSalary()).isEqualTo(450000);
    }

    @Test
    void testAddEmployee(){
        Employee employee1=repository.save(employee);
        Assertions.assertThat(employee1.getEmployeeId()).isGreaterThan(1);
    }
}