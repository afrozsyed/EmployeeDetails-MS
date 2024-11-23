package com.employeeDept.demo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeDept.demo.dto.EmployeeDto;
import com.employeeDept.demo.entities.Employees;
import com.employeeDept.demo.repositories.EmployeeRepo;
import com.employeeDept.demo.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public EmployeeDto getEmployeeById(Integer Id) {
		Optional<Employees> empById = this.employeeRepo.findById(Id);
		if (empById.isPresent())
			return repoToDto(empById.get());
		else
			return new EmployeeDto();
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employees> allEmp = this.employeeRepo.findAll();
		List<EmployeeDto> empDtoList = new ArrayList<EmployeeDto>();
		for (Employees employees : allEmp) {
			empDtoList.add(repoToDto(employees));
		}
		return empDtoList;
	}
	
	private EmployeeDto repoToDto(Employees employee) {
		EmployeeDto dto = new EmployeeDto();
		dto.setEmployeeId(employee.getEmployeeId());
		dto.setFirstName(employee.getFirstName());
		dto.setLastName(employee.getLastName());
		dto.setEmail(employee.getEmail());
		dto.setPhoneNumber(employee.getPhoneNumber());
		dto.setHireDate(employee.getHireDate());
		dto.setJobId(employee.getJobId());
		dto.setSalary(employee.getSalary());
		dto.setCommissionPct(employee.getCommissionPct());
		dto.setManagerId(employee.getManagerId());
		dto.setDepartmentId(employee.getDepartmentId());
		return dto;

	}
	
	private Employees DtoToRepo(EmployeeDto dto) {
		Employees employee = new Employees();
		employee.setEmployeeId(dto.getEmployeeId());
		employee.setFirstName(dto.getFirstName());
		employee.setLastName(dto.getLastName());
		employee.setEmail(dto.getEmail());
		employee.setPhoneNumber(dto.getPhoneNumber());
		employee.setHireDate(dto.getHireDate());
		employee.setJobId(dto.getJobId());
		employee.setSalary(dto.getSalary());
		employee.setCommissionPct(dto.getCommissionPct());
		employee.setManagerId(dto.getManagerId());
		employee.setDepartmentId(dto.getDepartmentId());
		return employee;

	}

	@Override
	public List<EmployeeDto> getEmployeesByDept(int deptId) {
		List<Employees> deptEmp = this.employeeRepo.findByDepartmentId(Integer.valueOf(deptId));
		List<EmployeeDto> empDtoList = new ArrayList<EmployeeDto>();
		for (Employees employees : deptEmp) {
			empDtoList.add(repoToDto(employees));
		}
		return empDtoList;
	}

	@Override
	public List<EmployeeDto> getEmployeesByManagerId(int managerId) {
		List<Employees> deptEmp = this.employeeRepo.findByManagerId(Integer.valueOf(managerId));
		List<EmployeeDto> empDtoList = new ArrayList<EmployeeDto>();
		for (Employees employees : deptEmp) {
			empDtoList.add(repoToDto(employees));
		}
		return empDtoList;
	}

	@Override
	public EmployeeDto addEmployee(EmployeeDto emp) {
		Employees savedEmp = this.employeeRepo.save(DtoToRepo(emp));
		return repoToDto(savedEmp);
	}

	@Override
	public String deleteEmployee(int empId) {
		this.employeeRepo.deleteById(empId);
		return "Deleted SuccessFully";
	}

}
