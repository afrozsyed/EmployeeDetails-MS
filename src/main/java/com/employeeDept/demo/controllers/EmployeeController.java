package com.employeeDept.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
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
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable int empId) {
        EmployeeDto employee = empService.getEmployeeById(empId);
        return employee == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(employee);
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
	public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto emp){
		EmployeeDto employee = empService.addEmployee(emp);
        return employee == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(employee);
	}
	
	@DeleteMapping("delete/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int empId){
		String deleteEmployeeResp = empService.deleteEmployee(empId);
        return deleteEmployeeResp == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(deleteEmployeeResp);
	}
	

}
