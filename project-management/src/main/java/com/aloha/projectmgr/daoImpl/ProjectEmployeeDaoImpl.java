package com.aloha.projectmgr.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.aloha.projectmgr.dao.Dao;
import com.aloha.projectmgr.dao.GenericDao;
import com.aloha.projectmgr.dao.ProjectEmployeeDao;
import com.aloha.projectmgr.dao.ProjectTaskDao;
import com.aloha.projectmgr.dto.ProjectDetailsDto;
import com.aloha.projectmgr.dto.ProjectPaymentScheduleDto;
import com.aloha.projectmgr.model.ProjectEmployee;

@Repository
public class ProjectEmployeeDaoImpl extends GenericDao implements ProjectEmployeeDao {
	Session session = null;
	
	@Override
	public void saveEmp(ProjectEmployee employee) {
		session = getSessionFactory().openSession();
		session.save(employee);
	}

	

	

}
