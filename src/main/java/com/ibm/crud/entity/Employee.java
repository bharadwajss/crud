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
@Data // lombok library-->
@Getter
@Setter
public class Employee {
   @Id  /// primary key
   @GeneratedValue(strategy = GenerationType.AUTO) //value will be auto-incremented
    private int employeeId;
    private String employeeName;
    private String designation;
    private double salary;
}
