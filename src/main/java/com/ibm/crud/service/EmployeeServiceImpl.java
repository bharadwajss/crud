/**
 * @author:Satish Bharatiya
 * @date: 11/11/2023
 */
package com.ibm.crud.service;

import com.ibm.crud.entity.Employee;
import com.ibm.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Employee addEmployee(Employee employee) {
        if(
                Objects.nonNull(employee.getEmployeeName()) &&
                "".equalsIgnoreCase(employee.getEmployeeName()))
        employeeRepository.save(employee);// in-build method called from crudrepository
        return employee;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(int employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public void updateEmployee(int employeeId, Employee employee) {
       Employee empDB= employeeRepository.findById(employeeId).get();
       if(employee.getEmployeeName()!=null)/// in books
           // if(null!=employee.getEmployeeName())// readable
       empDB.setEmployeeName(employee.getEmployeeName());
       empDB.setDesignation(employee.getDesignation());
       employeeRepository.save(empDB);
    }
}
