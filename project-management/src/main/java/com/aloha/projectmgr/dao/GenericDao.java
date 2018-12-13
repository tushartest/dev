package com.aloha.projectmgr.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;





public class GenericDao implements Dao {
	private static final  Logger log = Logger.getLogger(GenericDao.class.getName());
	/**
	 * Session factory - to be injected by spring
	 */
	@Autowired
	protected SessionFactory sessionFactory;
	 
	
	//protected SessionFactory sessionFactory;
	
	
	protected Session session;  

	
	
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory( ) {
		// return sessionFactory;
		if (sessionFactory == null) throw new DataAccessResourceFailureException("sessionFactory has not been set on session DAO before usage");
		return sessionFactory;
	}
	
	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public void save(Object object) {
		
		this.session = sessionFactory.openSession();
		try {
			session.getTransaction().begin();
			session.save(object);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			// session.flush();
			// session.close();

		}
		
	}


	public void persist(Object object) {
		//log.debug("saving  instance");
		this.session= sessionFactory.openSession();
		try {
			session.getTransaction().begin();
			session.persist(object);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			
		}
		
	}


	public void update(Object object) {
	//	log.debug("update  instance");
		this.session = sessionFactory.openSession();
		try {
			session.getTransaction().begin();
			session.update(object);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			

		}
		
	}


	public void saveOrUpdate(Object object) {
		
		this.session = sessionFactory.openSession();
		try {
			session.getTransaction().begin();
			session.saveOrUpdate(object);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			// session.flush();
			// session.close();

		}

		
	}

	public void delete(Object object) {
		//log.debug("saving  instance");
		this.session = sessionFactory.openSession();
		try {
			session.getTransaction().begin();
			session.delete(object);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			// session.flush();
			// session.close();

		}
		
	}
	
	public static void rollback(Transaction tx) {
        try {
            if (tx != null) {
                tx.rollback( );
            }
        }
        catch (HibernateException ignored) {
            log.error("Couldn't rollback Transaction", ignored);
           // throw new DAOException(ExceptionErrorCode.DAO_EXCEPTION, ignored);
        }
    }

	  public static void close(Session session) {
	        if (session != null && session.isOpen( )) {
	            try {
	                session.close( );
	            }
	            catch (HibernateException ignored) {
	                log.error("Couldn't close Session", ignored);
	                //throw new DAOException(ExceptionErrorCode.DAO_EXCEPTION, ignored);
	            }
	        }
	  }
}
	
