package com.aloha.projectmgr.serviceImpl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.projectmgr.dao.ProjectTaskDao;
import com.aloha.projectmgr.dto.ProjectDetailsDto;
import com.aloha.projectmgr.dto.ProjectPaymentScheduleDto;
import com.aloha.projectmgr.dto.form.ProjectForm;
import com.aloha.projectmgr.dto.form.ProjectPaymentForm;
import com.aloha.projectmgr.model.Project;
import com.aloha.projectmgr.model.ProjectDetails;
import com.aloha.projectmgr.model.ProjectPaymentSchedule;
import com.aloha.projectmgr.service.ProjectTaskService;



@Service
public class ProjectTaskServiceImpl implements ProjectTaskService {
    
	@Autowired
	private ProjectTaskDao projectTaskDao;
	
	@Override
	public void saveProject(ProjectForm projectForm) {

		Project project = new Project();
		ProjectDetails projectdetails = new ProjectDetails();
		
		if(projectForm.getProjectId()!=0){
			project.setProjectId(projectForm.getProjectId());
		}
		project.setName(projectForm.getName());
		//project.setContactNo(projectForm.getContactNo());
		project.setEmail(projectForm.getEmail());
		project.setWebsite(projectForm.getWebsite());
		if (!(projectForm.getStatus() ==null)){
			project.setStatus(projectForm.getStatus());
		}
		project.setStatus(ProjectTaskService.ACTIVE_STATUS);
		project.setCreatedBy(projectForm.getCreatedBy());
		project.setCreateDate(new Date());
		projectTaskDao.saveOrUpdate(project);
		
		projectdetails.setProjectId(project.getProjectId());
		projectdetails.setAddress(projectForm.getAddress());
		
		projectdetails.setContactPerson(projectForm.getContactPerson());

		projectdetails.setProjectType(projectForm.getProjectType());
	    projectdetails.setProposedcost(projectForm.getProposedcost());
		
		projectdetails.setStartDate(projectForm.getStartDate());
		projectTaskDao.saveOrUpdate(projectdetails);
		
	}

	@Override
	public List<ProjectDetailsDto> getAllProjects() {
		
		return projectTaskDao.getAllProject();
	}

	@Override
	public ProjectDetailsDto getProjectDetails(Integer projectId) {
		
		return projectTaskDao.getProjectDetails(projectId);
	}
	@Override
	public void saveProjectPaymentSchedule(ProjectPaymentForm projectPaymentform,Integer projectId) {
		
		ProjectPaymentSchedule proPaymentScedule = new ProjectPaymentSchedule();
		
		if(projectPaymentform.getPaymentId()!=0){
			proPaymentScedule.setPaymentId(projectPaymentform.getPaymentId());
		}
		proPaymentScedule.setProjectId(projectId);
		proPaymentScedule.setTitle(projectPaymentform.getTitle());
		proPaymentScedule.setAmount(projectPaymentform.getAmount());
		proPaymentScedule.setExpecteddate(projectPaymentform.getExpecteddate());
		proPaymentScedule.setUpdatedate(new Date());
		proPaymentScedule.setAmtreceivedflag(projectPaymentform.getAmtreceivedflag());
		proPaymentScedule.setComments(projectPaymentform.getComments());
		projectTaskDao.saveOrUpdate(proPaymentScedule);
	}

	@Override
	public List<ProjectPaymentScheduleDto> getProjectPaymentsSchedules(Integer projectId) {
	
		return projectTaskDao.getAllPaymentsSchedule(projectId);
	}
	
	@Override
	public void deletePaymentsScehdule(Integer paymentId){
		ProjectPaymentSchedule proPaymentScedule = new ProjectPaymentSchedule();
		proPaymentScedule.setPaymentId(paymentId);
		projectTaskDao.delete(proPaymentScedule);
		
	}
}