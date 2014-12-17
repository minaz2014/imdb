package com.townscript.imdb.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	    User user = new User();
	    user.setId(rs.getInt("ID"));
	    user.setUsername(rs.getString("USER_NAME"));
	    user.setEmailid(rs.getString("EMAIL_ID"));
	    user.setPassword(rs.getString("PWD"));
	    
	    
		return user;
	}

}