package com.townscript.imdb.dao.user;

import com.townscript.imdb.model.User;

public interface UserDao {

	public int addUser(User user);

	public boolean checkUserExist(String emailId);
	public User loadUser(String emailId);
}

