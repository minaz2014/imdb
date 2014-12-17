package com.townscript.imdb.ui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.townscript.imdb.model.User;
import com.townscript.imdb.service.user.UserSerice;
import com.townscript.imdb.service.user.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Logout user
		if(request.getRequestURI().equals("/imdb/user/logout")){
			HttpSession session=request.getSession();  
			session.removeAttribute("userid");
			session.invalidate();  
			response.sendRedirect("/imdb/login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Register User

		if(request.getRequestURI().equals("/imdb/user/add")) {
			String userName = request.getParameter("username");
			String emailId = request.getParameter("emailid");
			String password = request.getParameter("password");
			UserSerice userSerice = new UserServiceImpl();
			User user = new User();
			user.setUsername(userName);
			user.setEmailid(emailId);
			user.setPassword(password);
			int id = userSerice.addUser(user);

			response.sendRedirect("/imdb/login");
		}

		// Login User
		if(request.getRequestURI().equals("/imdb/user/login")){
			String emailid = request.getParameter("emailid");
			String password = request.getParameter("password");
			UserSerice userSerice = new UserServiceImpl();
			User user;
			try {
				user = userSerice.loginUser(emailid, password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.getOutputStream().write(e.getMessage().getBytes());
				return;
			}


			HttpSession session=request.getSession();  
			session.setAttribute("userid",user.getId());  
			session.setAttribute("username",user.getUsername());  


		}


	}


}
