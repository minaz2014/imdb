package com.townscript.imdb.dao.user;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.townscript.imdb.model.User;
import com.townscript.imdb.model.UserRowMapper;

public class UserDaoImpl implements UserDao {

	@Override
	public int addUser(final User user) {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setDatabaseName("imdb_db");
		dataSource.setUser("root");
		dataSource.setPassword("boxmarker");
		dataSource.setServerName("localhost");
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		KeyHolder holder = new GeneratedKeyHolder();

		try {
		jdbc.update(new PreparedStatementCreator() {           

		                @Override
		                public PreparedStatement createPreparedStatement(Connection connection)
		                        throws SQLException {
		                    PreparedStatement ps = connection.prepareStatement("" +
		                    		"INSERT INTO USER(USER_NAME,EMAIL_ID,PWD) VALUES ('"+user.getUsername()+"','"+user.getEmailid()+"','"+user.getPassword()+"');", Statement.RETURN_GENERATED_KEYS);
		                    
		                    return ps;
		                }
		}, holder);
		
		
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return holder.getKey().intValue();
	}

	@Override
	public boolean checkUserExist(String emailId) {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setDatabaseName("imdb_db");
		dataSource.setUser("root");
		dataSource.setPassword("boxmarker");
		dataSource.setServerName("localhost");
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
	
		String sql = "SELECT *FROM USER WHERE EMAIL_ID = ?";
		User user;
		try {
				user = jdbc.queryForObject(
						sql, new Object[] { emailId }, new UserRowMapper());
		} catch (Exception e) {
			return false;
		}
			if(user == null) {
				return false;
			}

		
		return true;
	}

	@Override
	public User loadUser(String emailId) {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setDatabaseName("imdb_db");
		dataSource.setUser("root");
		dataSource.setPassword("boxmarker");
		dataSource.setServerName("localhost");
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
	
		String sql = "SELECT * FROM USER WHERE EMAIL_ID = ?";
				User user = jdbc.queryForObject(
						sql, new Object[] { emailId }, new UserRowMapper());
	
		
		return user;
	}

}
