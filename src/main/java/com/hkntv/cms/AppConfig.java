package com.hkntv.cms;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan(basePackageClasses = AppConfig.class)
@PropertySource({ "classpath:jdbc.properties" })
public class AppConfig {

	@Autowired
	Environment env;

	private DataSource createDataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser("id ");
		dataSource.setPassword("pw ");
		dataSource.setJdbcUrl("");
//		dataSource.setDriverClass("com.mysql.jdbc.Driver ");
		dataSource.setInitialPoolSize(2);
		dataSource.setMinPoolSize(1);
		dataSource.setMaxPoolSize(10);
		dataSource.setMaxStatements(50);
		dataSource.setMaxIdleTime(60);

		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(createDataSource());
		return jdbcTemplate;
	}
}
