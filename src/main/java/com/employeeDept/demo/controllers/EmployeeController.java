package com.employeeDept.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeeDept.demo.dto.EmployeeDto;
import com.employeeDept.demo.services.EmployeeService;
import com.employeeDept.demo.utils.CustomResponse;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	@Autowired
	private CustomResponse customResponse;
	
	//**************** Get Mappings  **********************//
	
	 // Fetch all employees
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employees = empService.getAllEmployees();
        return employees.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(employees);
    }

    // Fetch an employee by ID
    @GetMapping("/{empId}")
    public CustomResponse getEmployeeById(@PathVariable(required = false) String empId) {
    	if (empId == null || empId.trim().isEmpty()) {
            String errorMessage = "Invalid input: empId is missing or empty.";
            return customResponse.generateCustomResponse(HttpStatus.NOT_FOUND.value(),"Failed",errorMessage, null);            
        }
    	
    	try {
            // Validate if empId is a numeric value
            int employeeId = Integer.parseInt(empId);
            CustomResponse employeeResp = empService.getEmployeeById(employeeId);
            return employeeResp;
        } catch (NumberFormatException ex) {
            String errorMessage = "Invalid input: empId must be a numeric value.";
            return customResponse.generateCustomResponse(HttpStatus.BAD_REQUEST.value(),"Failed",errorMessage, null);   
        }
    }

    // Fetch employees by department ID
    @GetMapping("/by-department")
    public ResponseEntity<List<EmployeeDto>> getEmployeesByDeptId(@RequestParam int deptId) {
        List<EmployeeDto> employees = empService.getEmployeesByDept(deptId);
        return employees.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(employees);
    }

    // Fetch employees by manager ID
    @GetMapping("/by-manager")
    public ResponseEntity<List<EmployeeDto>> getEmployeesByManagerId(@RequestParam int managerId) {
        List<EmployeeDto> employees = empService.getEmployeesByManagerId(managerId);
        return employees.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(employees);
    }
	
	@GetMapping("test")
	public String helloTest() {
		return "Hello I am running";
	}
	
	
	@PostMapping("add")
	public CustomResponse addEmployee(@RequestBody EmployeeDto emp){
		CustomResponse employeeResponse = empService.addEmployee(emp);
        return employeeResponse;
	}
	
	@DeleteMapping("delete/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int empId){
		String deleteEmployeeResp = empService.deleteEmployee(empId);
        return deleteEmployeeResp == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(deleteEmployeeResp);
	}
	

}
