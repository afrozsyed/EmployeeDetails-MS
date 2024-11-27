package com.employeeDept.demo.services;

import com.employeeDept.demo.dto.EmployeeDto;
import com.employeeDept.demo.utils.CustomResponse;


public interface EmployeeService {
	
	CustomResponse getEmployeeById(Integer Id);
	CustomResponse getAllEmployees();
	CustomResponse getEmployeesByDept(int deptId);
	CustomResponse getEmployeesByManagerId(int managerId);
	CustomResponse addEmployee(EmployeeDto emp);
	String deleteEmployee(int empId);

}
