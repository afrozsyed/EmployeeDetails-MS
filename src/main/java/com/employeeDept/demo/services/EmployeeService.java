package com.employeeDept.demo.services;

import java.util.List;


import com.employeeDept.demo.dto.EmployeeDto;


public interface EmployeeService {
	
	EmployeeDto getEmployeeById(Integer Id);
	List<EmployeeDto> getAllEmployees();
	List<EmployeeDto> getEmployeesByDept(int deptId);
	List<EmployeeDto> getEmployeesByManagerId(int managerId);
	EmployeeDto addEmployee(EmployeeDto emp);
	String deleteEmployee(int empId);

}
