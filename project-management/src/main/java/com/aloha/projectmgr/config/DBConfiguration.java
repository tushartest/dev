package com.aloha.projectmgr.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.aloha.projectmgr.model.Project;
import com.aloha.projectmgr.model.ProjectDetails;
import com.aloha.projectmgr.model.ProjectPaymentSchedule;
import com.mchange.v2.c3p0.ComboPooledDataSource;


@Configuration
@EnableTransactionManagement
public class DBConfiguration {
	@Value("${db.driver}")
	private String DB_DRIVER;

	@Value("${db.password}")
	private String DB_PASSWORD;

	@Value("${db.url}")
	private String DB_URL;

	@Value("${db.username}")
	private String DB_USERNAME;

	@Value("${hibernate.dialect}")
	private String HIBERNATE_DIALECT;

	@Value("${hibernate.show_sql}")
	private String HIBERNATE_SHOW_SQL;

	@Value("${hibernate.hbm2ddl.auto}")
	private String HIBERNATE_HBM2DDL_AUTO;

	@Value("${entitymanager.packagesToScan}")
	private String ENTITYMANAGER_PACKAGES_TO_SCAN;

	@Value("${hibernate.c3p0.max_size}")
	private String CONN_POOL_MAX_SIZE;

	@Value("${hibernate.c3p0.min_size}")
	private String CONN_POOL_MIN_SIZE;

	@Value("${hibernate.c3p0.idle_test_period}")
	private String CONN_POOL_IDLE_PERIOD;

	/*
	 * @Value("${db.driver}") private String DRIVER;
	 * 
	 * @Value("${db.password}") private String PASSWORD;
	 * 
	 * @Value("${db.url}") private String URL;
	 * 
	 * @Value("${db.username}") private String USERNAME;
	 * 
	 * @Value("${hibernate.dialect}") private String DIALECT;
	 * 
	 * @Value("${hibernate.show_sql}") private String SHOW_SQL;
	 * 
	 * @Value("${hibernate.hbm2ddl.auto}") private String HBM2DDL_AUTO;
	 * 
	 * @Value("${entitymanager.packagesToScan}") private String
	 * PACKAGES_TO_SCAN;
	 * 
	 * @Value("${hibernate.connection.pool_size}") private String pool_size;
	 * 
	 * @Value("${hibernate.connection.provider_class}") private String
	 * provider_class;
	 * 
	 * @Value("${hibernate.c3p0.breakAfterAcquireFailure}") private String
	 * breakAfterAcquireFailure;
	 * 
	 * @Value("${hibernate.c3p0.acquireRetryAttempts}") private String
	 * acquireRetryAttempts;
	 * 
	 * @Value("${hibernate.c3p0.acquireRetryDelay}") private String
	 * acquireRetryDelay;
	 * 
	 * @Value("${hibernate.c3p0.idleConnectionTestPeriod}") private String
	 * idleConnectionTestPeriod;
	 */

	/*
	 * @Value("${hibernate.c3p0.preferredTestQuery}") private String
	 * preferredTestQuery;
	 */

	/*
	 * @Bean public DataSource dataSource() { DriverManagerDataSource dataSource
	 * = new DriverManagerDataSource(); dataSource.setDriverClassName(DRIVER);
	 * dataSource.setUrl(URL); dataSource.setUsername(USERNAME);
	 * dataSource.setPassword(PASSWORD); return dataSource; }
	 */

	/*
	 * @Autowired
	 * 
	 * @Bean(name = "dataSource") public ComboPooledDataSource
	 * getPooledDataSource() { DriverManagerDataSource dataSource = new
	 * DriverManagerDataSource();
	 * dataSource.setDriverClassName(PROPERTY_NAME_DATABASE_DRIVER);
	 * dataSource.setUrl(PROPERTY_NAME_DATABASE_URL);
	 * dataSource.setUsername(PROPERTY_NAME_DATABASE_USERNAME);
	 * dataSource.setPassword(PROPERTY_NAME_DATABASE_PASSWORD); return
	 * dataSource; }
	 */

	@Bean
	public ComboPooledDataSource dataSource() {
		// a named datasource is best practice for later jmx monitoring
		ComboPooledDataSource dataSource = new ComboPooledDataSource();

		try {
			dataSource.setDriverClass(DB_DRIVER);
		} catch (PropertyVetoException pve) {
			System.out.println("Cannot load datasource driver (" + DB_DRIVER
					+ ") : " + pve.getMessage());
			return null;
		}
		dataSource.setJdbcUrl(DB_URL);
		dataSource.setUser(DB_USERNAME);
		dataSource.setPassword(DB_PASSWORD);
		dataSource.setMinPoolSize(Integer.parseInt(CONN_POOL_MIN_SIZE));
		dataSource.setMaxPoolSize(Integer.parseInt(CONN_POOL_MAX_SIZE));
		dataSource.setMaxIdleTime(Integer.parseInt(CONN_POOL_IDLE_PERIOD));

		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", HIBERNATE_DIALECT);
		hibernateProperties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
		hibernateProperties.put("hibernate.hbm2ddl.auto",
				HIBERNATE_HBM2DDL_AUTO);
		hibernateProperties.put("hibernate.connection.release_mode",
				"after_transaction");
		sessionFactoryBean.setHibernateProperties(hibernateProperties);

		return sessionFactoryBean;
	}

	@Autowired
	@Bean(name = "hibernate5AnnotatedSessionFactory")
	LocalSessionFactoryBuilder getLocalSessionFactoryBean() {
		LocalSessionFactoryBuilder localSessionFactoryBean = new LocalSessionFactoryBuilder(
				dataSource());
		localSessionFactoryBean.scanPackages(ENTITYMANAGER_PACKAGES_TO_SCAN)
				.addAnnotatedClass(Project.class)
		         .addAnnotatedClass(ProjectDetails.class)
		         .addAnnotatedClass(ProjectPaymentSchedule.class);
		   

		localSessionFactoryBean.addProperties(getHibernateProperties());
		localSessionFactoryBean.buildSessionFactory();

		return localSessionFactoryBean;
	}

	/*
	 * @Bean public HibernateTransactionManager transactionManager() {
	 * HibernateTransactionManager transactionManager = new
	 * HibernateTransactionManager();
	 * transactionManager.setSessionFactory(sessionFactory().getObject());
	 * return transactionManager; }
	 */
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getLocalSessionFactoryBean()
				.buildSessionFactory());
		return transactionManager;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
		properties.put("hibernate.current_session_context_class", "thread");
		properties.put("hibernate.dialect", HIBERNATE_DIALECT);
		return properties;
	}
}