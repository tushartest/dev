package com.aloha.projectmgr.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aloha.projectmgr.dao.EmployeeService;
import com.aloha.projectmgr.model.ProjectEmployee;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

@Autowired 
private EmployeeService employeeService;	

	@PostMapping	
	public String saveEmp(@RequestParam Map<String,String> requestParams) {
		
		ProjectEmployee employee=new ProjectEmployee();
		employee.setEmp_id(Integer.parseInt(requestParams.get("id")));
		employee.setProjectId(Integer.parseInt(requestParams.get("emp_id")));
		employee.setEmp_email(requestParams.get("name"));
        employee.setEmp_name(requestParams.get("emial"));	
        employee.setEmp_contactNo(requestParams.get("contactNo"));		
        employeeService.saveEmployee(employee) ;
		return "ok";
	} 
	
    @GetMapping	
	public String saveEmployee(@RequestParam int pgId, @RequestParam int emp_id, @RequestParam(required = false) String emp_name, @RequestParam(required = false) String emp_email
            , @RequestParam String emp_contactNo) {
    	System.out.println("---"+pgId+ emp_id+ emp_name + emp_email+ emp_contactNo);
		return "ok";
	} 	
}
