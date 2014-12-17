package com.townscript.imdb.ui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLoginServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session=req.getSession();  
	    Integer id = (Integer) session.getAttribute("userid"); 
	    String username = (String) session.getAttribute("username"); 
	   if(id!=null) 
	   {
		   resp.sendRedirect("/imdb/homepage");
		   return;
	   }	
		

			PrintWriter pw = resp.getWriter();
			
			
			pw.println("<html>");
			
			pw.println("<head>");
			

			pw.println("<link rel='stylesheet' href='/imdb/css/registration.css'>");
			pw.println("<script src='/imdb/js/login.js'></script>");
			pw.println("</head>");

			pw.println("<body>");


			pw.println("<div align='center'>");
			pw.println("<fieldset>");
			pw.println("<form name='login' onsubmit='validateform()'>");
			pw.println("<h1>LOGIN TO IMDB</h1>");

			//pw.println("Email-id: <br>");
			pw.println("<br>");
			pw.println("<input type='text' placeholder='Email-id' name='emailid' style='height:25px'>");
			pw.println("<br><br><br>");
			//pw.println("Password: <br>");
			pw.println("<input type='password' placeholder='Password' name='password' style='height:25px'>");
			pw.println("<br><br>");
			
			pw.println("<br><br>");
			pw.println("<input style='padding:5px;' type='submit' value='Sign In'>");
			pw.println("<a href='/imdb/register'>New User?</a>");
			pw.println("</form>");
			pw.println("</fieldset>");
			pw.println("</div>");
			pw.println("</body");
			pw.println("</html>");

		}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	

}
