package com.employeeDept.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeDept.demo.entities.Employees;

public interface EmployeeRepo extends JpaRepository<Employees, Integer> {

	List<Employees> findByDepartmentId(Integer deptId);

	List<Employees> findByManagerId(Integer managerId);

}
