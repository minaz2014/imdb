package com.townscript.imdb.service.user;

import com.townscript.imdb.model.User;

public interface UserSerice {

	public int addUser(User user);
	public User loginUser(String emailid, String password) throws Exception;
}
