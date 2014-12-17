package com.townscript.imdb;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class JdbcTemplateFactory {
	
	private static JdbcTemplate jdbcTemplate;
	
	public static JdbcTemplate getInstance(){
		if (jdbcTemplate==null) {
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setDatabaseName("imdb_db");
			dataSource.setUser("root");
			dataSource.setPassword("boxmarker");
			dataSource.setServerName("localhost");
			jdbcTemplate = new JdbcTemplate(dataSource);
		}
		return jdbcTemplate;
	}

}
