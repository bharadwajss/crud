package com.ibm.crud.service;

import com.ibm.crud.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee addEmployee(Employee employee);

    List<Employee> getEmployees();

    Optional<Employee> getEmployeeById(int employeeId);

    void deleteEmployee(int employeeId);

    void updateEmployee(int employeeId, Employee employee);

    Employee findByEmployeeName(String employeeName);
    Employee findByEmployeeNameIgnoreCase(String name);
}
