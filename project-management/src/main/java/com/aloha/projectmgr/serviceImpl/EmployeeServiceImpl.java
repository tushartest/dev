package com.aloha.projectmgr.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.projectmgr.dao.EmployeeService;
import com.aloha.projectmgr.dao.ProjectEmployeeDao;
import com.aloha.projectmgr.model.ProjectEmployee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

@Autowired 
private ProjectEmployeeDao projectEmployeeDao;

	@Override
	public String saveEmployee(ProjectEmployee projectEmployee) {
		projectEmployeeDao.saveEmp(projectEmployee);
		return "save successfuly";
	}

}
