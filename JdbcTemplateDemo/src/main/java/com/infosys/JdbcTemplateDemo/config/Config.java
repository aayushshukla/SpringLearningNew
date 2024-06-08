package com.infosys.JdbcTemplateDemo.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.infosys.JdbcTemplateDemo.*")
public class Config {
	
	private String dbuser="postgres";
	private String dbpassword="password";
	// api:database://host:portno/databasename
	private String dburl="jdbc:postgresql://localhost:5432/pdadb"; 
	
	/*
	 * @Bean("ds") 
	 * public DataSource getDataSource() { DriverManagerDataSource
	 * dataSource = new DriverManagerDataSource(); // Set the JDBC driver class
	 * name. This driver will get initializedon startup, registering itself with the
	 * JDK's DriverManager dataSource.setDriverClassName("org.postgresql.Driver");
	 * dataSource.setUrl(dburl); dataSource.setUsername(dbuser);
	 * dataSource.setPassword(dbpassword); return dataSource; }
	 */
	
	@Bean("ds")
	public BasicDataSource getDataSource()
	{
		BasicDataSource dataSource = new BasicDataSource();
		// Set the JDBC driver class name. This driver will get initializedon startup, registering itself with the JDK's DriverManager
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl(dburl);
		dataSource.setUsername(dbuser);
		dataSource.setPassword(dbpassword);
		return dataSource;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate()
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		// Set the JDBC DataSource to obtain connections from.
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}

}
