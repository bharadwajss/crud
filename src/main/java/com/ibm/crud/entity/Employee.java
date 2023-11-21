/**
 * @author:Satish Bharatiya
 * @date: 11/11/2023
 */
package com.ibm.crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
public class Employee {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;
    private String employeeName;
    private String designation;
    private double salary;
}
