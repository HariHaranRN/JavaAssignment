package com;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com"})
@PropertySource(value= {"classpath:application.properties"})
public class HibernateConfiguration {

	@Autowired
	private Environment environment;
	
	private Properties getDBProperties() {
		Properties prop=new Properties();
		prop.put("hibernate.connection.username", 
					environment.getRequiredProperty("hibernate.connection.username"));
		prop.put("hibernate.connection.password", 
				environment.getRequiredProperty("hibernate.connection.password"));
		prop.put("hibernate.dialect",environment.getRequiredProperty("hibernate.dialect"));
		prop.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		prop.setProperty("hibernate.hbm2ddl.auto",environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		return prop;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));		
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		return dataSource;
	}
		
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setHibernateProperties(getDBProperties());
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] {"com.model"});
		return sessionFactory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager=new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}
}








