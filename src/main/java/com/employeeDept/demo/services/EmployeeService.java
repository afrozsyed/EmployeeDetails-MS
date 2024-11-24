package com.employeeDept.demo.services;

import java.util.List;


import com.employeeDept.demo.dto.EmployeeDto;
import com.employeeDept.demo.utils.CustomResponse;


public interface EmployeeService {
	
	CustomResponse getEmployeeById(Integer Id);
	List<EmployeeDto> getAllEmployees();
	List<EmployeeDto> getEmployeesByDept(int deptId);
	List<EmployeeDto> getEmployeesByManagerId(int managerId);
	CustomResponse addEmployee(EmployeeDto emp);
	String deleteEmployee(int empId);

}
