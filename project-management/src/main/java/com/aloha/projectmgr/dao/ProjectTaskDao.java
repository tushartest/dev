package com.aloha.projectmgr.dao;

import java.util.List;

import com.aloha.projectmgr.dto.ProjectDetailsDto;
import com.aloha.projectmgr.dto.ProjectPaymentScheduleDto;


public interface ProjectTaskDao extends Dao {
	
	List<ProjectDetailsDto> getAllProject();

	ProjectDetailsDto getProjectDetails(Integer projectId);

	List<ProjectPaymentScheduleDto> getAllPaymentsSchedule(Integer projectId);

}
