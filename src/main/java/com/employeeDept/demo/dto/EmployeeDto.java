package com.employeeDept.demo.dto;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EmployeeDto {

	private int employeeId;

	private String firstName;

	private String lastName;

	private String email;

	private String phoneNumber;

	private Date hireDate;

	private String jobId;

	private BigDecimal salary;

	private BigDecimal commissionPct;

	private Integer managerId;

	private Integer departmentId;
}
