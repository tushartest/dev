package com.aloha.projectmgr.service;

import java.util.List;

import com.aloha.projectmgr.dto.ProjectDetailsDto;
import com.aloha.projectmgr.dto.ProjectPaymentScheduleDto;
import com.aloha.projectmgr.dto.form.ProjectForm;
import com.aloha.projectmgr.dto.form.ProjectPaymentForm;



public interface ProjectTaskService {
	public static final String ACTIVE_STATUS = "Active";
	public static final String CLOSED_STATUS = "Closed";
	public static final String CANCELLED_STATUS = "Cancelled";
	public static final String ONHOLD_STATUS = "On-Hold";
	
	void saveProject(ProjectForm form);

	List<ProjectDetailsDto> getAllProjects();

	ProjectDetailsDto getProjectDetails(Integer projectId);
	
	void saveProjectPaymentSchedule(ProjectPaymentForm projectPaymentform,Integer projectId);

	List<ProjectPaymentScheduleDto> getProjectPaymentsSchedules(Integer projectId);

	void deletePaymentsScehdule(Integer paymentId);
}
