package com.aloha.projectmgr.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aloha.projectmgr.dto.ProjectDetailsDto;
import com.aloha.projectmgr.dto.ProjectPaymentScheduleDto;
import com.aloha.projectmgr.dto.form.ProjectForm;
import com.aloha.projectmgr.dto.form.ProjectPaymentForm;
import com.aloha.projectmgr.exception.ParameterValidationException;
import com.aloha.projectmgr.service.ProjectTaskService;


@RestController
@RequestMapping("/projects")
public class ProjectTaskController {

	@Autowired
	private ProjectTaskService projectTaskService;

    @PostMapping
	public void addUpdateProject(@RequestBody @Valid ProjectForm projectform,
			BindingResult bindingResult) throws ParameterValidationException {
		if (bindingResult != null && bindingResult.hasErrors()) {
			throw new ParameterValidationException(bindingResult);
		}
		projectTaskService.saveProject(projectform);
	}

	@GetMapping
	public List<ProjectDetailsDto> getAllProjects() {

		return projectTaskService.getAllProjects();
	}

	@GetMapping(value = "/{projectId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ProjectDetailsDto getProjectDetails(
			@PathVariable("projectId") Integer projectId) {

		return projectTaskService.getProjectDetails(projectId);
	}

	 @PostMapping(value = "/{projectId}/financials")
	 public void addUpdatePaymentSchedule(
			@RequestBody @Valid ProjectPaymentForm projectPaymentform,
		    @PathVariable("projectId") Integer projectId,
			BindingResult bindingResult) throws ParameterValidationException {
		if (bindingResult != null && bindingResult.hasErrors()) {
			throw new ParameterValidationException(bindingResult);
		}
		projectTaskService.saveProjectPaymentSchedule(projectPaymentform,
				projectId);
	}
	
	  @GetMapping(value = "/{projectId}/financials",produces = MediaType.APPLICATION_JSON_VALUE)
	  public List<ProjectPaymentScheduleDto> getAllProjectPaymentSchedules(
				@PathVariable("projectId") Integer projectId) {
             
		  return projectTaskService.getProjectPaymentsSchedules(projectId);
	}
	
		@DeleteMapping( value = "/{projectId}/financials/{paymentId}")
		public void removePaymentschedule(@PathVariable("projectId") Integer projectId,@PathVariable("paymentId") Integer paymentId){
			
		 projectTaskService.deletePaymentsScehdule(paymentId);
	}
}
