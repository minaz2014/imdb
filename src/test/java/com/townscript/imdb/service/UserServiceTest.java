package com.townscript.imdb.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.townscript.imdb.JdbcTemplateFactory;
import com.townscript.imdb.model.User;
import com.townscript.imdb.model.UserRowMapper;
import com.townscript.imdb.service.user.UserSerice;
import com.townscript.imdb.service.user.UserServiceImpl;
import static org.junit.Assert.*;

public class UserServiceTest {
	
	private JdbcTemplate jdbcTemplate = JdbcTemplateFactory.getInstance();
	
	@Before
	public void clearDbBeforeTest() {
		clear();
	}
	
	@After
	public void clearDbAfterTest() {
		clear();
	}
	
	private void clear() {
		jdbcTemplate.update("DELETE FROM USER");
	}

	@Test
	public void testAddUserService() {
		User user = new User();
		user.setUsername("minaz1");
		user.setEmailid("minaz1@gmail.com");
		user.setPassword("komal123");
		UserSerice userSerice = new UserServiceImpl();
		int id = userSerice.addUser(user);
		
		
		String sql = "SELECT * FROM USER WHERE ID = ?";
		
		User loadedUser = jdbcTemplate.queryForObject(
				sql, new Object[] { id }, new UserRowMapper());
		
		assertEquals(user.getUsername(), loadedUser.getUsername());
		assertEquals(user.getEmailid(), loadedUser.getEmailid());
		assertEquals(user.getPassword(), loadedUser.getPassword());
	}
	
	@Test
	public void testLoginUserService() {
		jdbcTemplate.update("INSERT INTO USER(USER_NAME,EMAIL_ID,PWD) VALUES ('minaz1','minaz1@gmail.com','komal123');");
		UserSerice userSerice = new UserServiceImpl();
		User user;
		try {
			user = userSerice.loginUser("minaz1@gmail.com","komal123");
			assertEquals("minaz1", user.getUsername());
			assertEquals("minaz1@gmail.com", user.getEmailid());
			assertEquals("komal123", user.getPassword());

		} catch (Exception e) {
			
			e.printStackTrace();
			fail(e.getMessage());
		}
		

		
		
	}

}