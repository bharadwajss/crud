/**
 * @author:Satish Bharatiya
 * @date: 11/11/2023
 */
package com.ibm.crud.controller;

import com.ibm.crud.entity.Employee;
import com.ibm.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
   // @RequestMapping(value = "/addEmployee",method = RequestMethod.POST)
    @PostMapping("/addEmployee")// adding record
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
        //return "Employee added successfully";
    }

    @GetMapping("/getEmployee")//retrieving all records
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/getEmployeeById/{id}")//retrieve record by empId
    public Optional<Employee> getEmployeeById(@PathVariable("id") int employeeId)
    {
        return employeeService.getEmployeeById(employeeId);
    }

    @DeleteMapping("/deleteEmployee/{id}") //delete by empid
    public String deleteEmployee(@PathVariable("id") int employeeId)
    {
        employeeService.deleteEmployee(employeeId);
        return "Employee deleted successfully";
    }

    @PutMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable("id") int employeeId, @RequestBody Employee employee){
        employeeService.updateEmployee(employeeId, employee);
        return "updated record successfully";
    }
}
