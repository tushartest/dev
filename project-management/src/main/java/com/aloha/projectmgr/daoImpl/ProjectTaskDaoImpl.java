package com.aloha.projectmgr.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.aloha.projectmgr.dao.GenericDao;
import com.aloha.projectmgr.dao.ProjectTaskDao;
import com.aloha.projectmgr.dto.ProjectDetailsDto;
import com.aloha.projectmgr.dto.ProjectPaymentScheduleDto;

@Repository
@Transactional
public class ProjectTaskDaoImpl extends GenericDao implements ProjectTaskDao {

	@Override
	public List<ProjectDetailsDto> getAllProject() {

		Session session = null;
		try {
			session = getSessionFactory().openSession();
			StringBuilder query = new StringBuilder();
			query.append("SELECT p.projectId, p.createDate, p.createdBy, p.email, p.name, p.status, p.website, ")
				 .append("address,pd.contactPerson,")
				 .append("pd.proposedcost ")
				 .append("FROM project p ")
				 .append("join projectdetails pd on p.projectId = pd.projectId ");
			SQLQuery qry = session.createSQLQuery(query.toString());
			qry.setResultTransformer(Transformers
					.aliasToBean(ProjectDetailsDto.class));
			@SuppressWarnings("unchecked")
			List<ProjectDetailsDto> projectDetailsDto = qry.list();
			return projectDetailsDto;
		} catch (RuntimeException re) {
			re.printStackTrace();
			throw new RuntimeException();
		} finally {
			GenericDao.close(session);
		}
	}

	@Override
	public ProjectDetailsDto getProjectDetails(Integer projectId) {
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			StringBuilder query = new StringBuilder();
			query.append("SELECT p.projectId, p.createDate, p.createdBy,p.email, p.name,pd.contactNo,p.status, p.website, ")
				 .append("pd.address,pd.contactPerson,")
				 .append("pd.proposedcost ")
				 .append("FROM project p ")
				 .append("join projectdetails pd on p.projectId = pd.projectId ")
				 .append("where p.projectId = :projectId ");
			ProjectDetailsDto projectDetails = (ProjectDetailsDto) session
				 .createSQLQuery(query.toString())
				 .setInteger("projectId", projectId)
				 .setResultTransformer(
						Transformers.aliasToBean(ProjectDetailsDto.class))
				 .uniqueResult();
			return projectDetails;
		} catch (RuntimeException re) {
			re.printStackTrace();
			throw new RuntimeException();
		} finally {
			GenericDao.close(session);
		}
	}

	@Override
	public List<ProjectPaymentScheduleDto> getAllPaymentsSchedule(
			Integer projectId) {
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			StringBuilder query = new StringBuilder();
			query.append("SELECT p.paymentId, p.amount, p.amt_received_flag, p.comments, p.expected_date, p.projectId, p.title, p.update_date ")
				 .append("FROM project_payment_schedule p ")
				 .append("where p.projectId = :projectId ");
			@SuppressWarnings("unchecked")
			List<ProjectPaymentScheduleDto> projectPaymentDetails = (List<ProjectPaymentScheduleDto>) session
				 .createSQLQuery(query.toString())
				 .setParameter("projectId", projectId).list();
			return projectPaymentDetails;
		} catch (RuntimeException re) {
			re.printStackTrace();
			throw new RuntimeException();
		} finally {
			GenericDao.close(session);
		}
	}

}
