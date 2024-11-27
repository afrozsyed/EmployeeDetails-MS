package com.employeeDept.demo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.employeeDept.demo.dto.EmployeeDto;
import com.employeeDept.demo.entities.Employees;
import com.employeeDept.demo.repositories.EmployeeRepo;
import com.employeeDept.demo.services.EmployeeService;
import com.employeeDept.demo.utils.CustomResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private CustomResponse customResponse;

	@Override
	public CustomResponse getEmployeeById(Integer Id) {
		try {
			Optional<Employees> empById = this.employeeRepo.findById(Id);
			if (empById.isPresent())
				return customResponse.generateCustomResponse(HttpStatus.FOUND.value(),"Success","Employee details fetched SuccessFully", repoToDto(empById.get()));
			else
				return customResponse.generateCustomResponse(HttpStatus.NOT_FOUND.value(),"Failed","Employee details Not Found", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return customResponse.generateCustomResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Failed","Error Occured"+e.getMessage(), null);
		}
	}

	@Override
	public CustomResponse getAllEmployees() {
		try {
			List<Employees> allEmp = this.employeeRepo.findAll();
			List<EmployeeDto> empDtoList = new ArrayList<EmployeeDto>();
			for (Employees employees : allEmp) {
				empDtoList.add(repoToDto(employees));
			}
			return customResponse.generateCustomResponse(HttpStatus.FOUND.value(),"Success","Employee details fetched SuccessFully", empDtoList);
		} catch (Exception e) {
			e.printStackTrace();
			return customResponse.generateCustomResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Failed","Error Occured"+e.getMessage(), null);
		}
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
	public CustomResponse getEmployeesByDept(int deptId) {
		try {
			List<Employees> deptEmp = this.employeeRepo.findByDepartmentId(Integer.valueOf(deptId));
			List<EmployeeDto> empDtoList = new ArrayList<EmployeeDto>();
			for (Employees employees : deptEmp) {
				empDtoList.add(repoToDto(employees));
			}
			if (empDtoList!=null && !empDtoList.isEmpty() && empDtoList.size()>0)
				return customResponse.generateCustomResponse(HttpStatus.FOUND.value(),"Success","Employee details fetched SuccessFully", empDtoList);
			else
				return customResponse.generateCustomResponse(HttpStatus.NOT_FOUND.value(),"Failed","Employee details Not Found", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return customResponse.generateCustomResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Failed","Error Occured"+e.getMessage(), null);
		}
	}

	@Override
	public CustomResponse getEmployeesByManagerId(int managerId) {
		try {
			List<Employees> deptEmp = this.employeeRepo.findByManagerId(Integer.valueOf(managerId));
			List<EmployeeDto> empDtoList = new ArrayList<EmployeeDto>();
			for (Employees employees : deptEmp) {
				empDtoList.add(repoToDto(employees));
			}
			if (empDtoList!=null && !empDtoList.isEmpty() && empDtoList.size()>0)
				return customResponse.generateCustomResponse(HttpStatus.FOUND.value(),"Success","Employee details fetched SuccessFully", empDtoList);
			else
				return customResponse.generateCustomResponse(HttpStatus.NOT_FOUND.value(),"Failed","Employee details Not Found", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return customResponse.generateCustomResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Failed","Error Occured"+e.getMessage(), null);
		}
	}

	@Override
	public CustomResponse addEmployee(EmployeeDto emp) {
		try {
			Employees savedEmp = this.employeeRepo.save(DtoToRepo(emp));
			if(savedEmp!=null)
				return customResponse.generateCustomResponse(HttpStatus.CREATED.value(),"Success","Employee Created SuccessFully", repoToDto(savedEmp));
			else
				return customResponse.generateCustomResponse(HttpStatus.FORBIDDEN.value(),"Failed","Failed to create Employee", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return customResponse.generateCustomResponse(HttpStatus.FORBIDDEN.value(),"Failed","UnExpected Error Occured:"+e.getMessage(), null);
		}
	}

	@Override
	public String deleteEmployee(int empId) {
		this.employeeRepo.deleteById(empId);
		return "Deleted SuccessFully";
	}

}
