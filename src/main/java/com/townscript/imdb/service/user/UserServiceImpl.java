package com.townscript.imdb.service.user;

import com.townscript.imdb.dao.user.UserDao;
import com.townscript.imdb.dao.user.UserDaoImpl;
import com.townscript.imdb.model.User;

public class UserServiceImpl implements UserSerice {

	@Override
	public int addUser(User user) {
		UserDao userDao = new UserDaoImpl();
		return userDao.addUser(user);
	}

	@Override
	public User loginUser(String emailid, String password) throws Exception {
		UserDao userDao = new UserDaoImpl();
		if(!userDao.checkUserExist(emailid))
		{
			throw new Exception("This email-id is not used!");
		}
		else
		{
			User user = userDao.loadUser(emailid);
			if(!user.getPassword().equals(password))
			{
				throw new Exception("Password does not match!");
			}
			
			return user;
		}
	}

}
