package com.omnisport.hello.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HelloAppHibernateConfig {

	@Bean
	public LocalSessionFactoryBean sessionFactory() throws IOException{
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.omnisport.hello.model");
		sessionFactory.setHibernateProperties(hibernateProperties());
		sessionFactory.afterPropertiesSet();
		return sessionFactory;
	}
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("");
		dataSource.setUrl("");
		dataSource.setUsername("admin");
		dataSource.setPassword("Admin123!");
		return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager hibernateTransactionManager() throws IOException{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
	
	@Bean
	public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory) {
		return new HibernateTemplate(sessionFactory);
	}
	
	private final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "validate");
		hibernateProperties.setProperty("hibernate.dialect", "");
		hibernateProperties.setProperty("current_session_context_class", "true");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		hibernateProperties.setProperty("hibernate.allow_update_outside_transaction", "true");
		hibernateProperties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
		return hibernateProperties;
	}
}
