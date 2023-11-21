package com.ibm.crud.repository;

import com.ibm.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //this is optional annotation
public interface EmployeeRepository  extends JpaRepository<Employee,Integer> {

}
