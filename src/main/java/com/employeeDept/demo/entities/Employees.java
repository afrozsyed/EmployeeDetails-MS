package com.employeeDept.demo.entities;

import java.math.BigDecimal;
import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "EMPLOYEES")
@NoArgsConstructor
@Getter
@Setter
public class Employees {

    @Id
    @Column(name = "EMPLOYEE_ID")
    private int employeeId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "HIRE_DATE", nullable = false)
    private Date hireDate;

    @Column(name = "JOB_ID", nullable = false)
    private String jobId;

    @Column(name = "SALARY")
    private BigDecimal salary;

    @Column(name = "COMMISSION_PCT")
    private BigDecimal commissionPct;

    @Column(name = "MANAGER_ID")
    private Integer managerId;

    @Column(name = "DEPARTMENT_ID")
    private Integer departmentId;
}

