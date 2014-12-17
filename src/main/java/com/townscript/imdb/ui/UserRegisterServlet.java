package com.townscript.imdb.ui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserRegisterServlet
 */
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		
		pw.println("<html>");
		
		pw.println("<head>");
		

		pw.println("<link rel='stylesheet' href='/imdb/css/registration.css'>");
		pw.println("<script src='/imdb/js/registration.js'></script>");
		pw.println("</head>");

		pw.println("<body>");


		pw.println("<div align='center'>");
		pw.println("<fieldset>");
		pw.println("<form name='registration' action='/imdb/user/add' onsubmit='return validateform()' method='post' >");
		pw.println("<h1>NEW TO IMDB? SIGN UP</h1>");

		//pw.println("Username: <br>");
		pw.println("<input type='text' placeholder='Username'  name='username'>");
		pw.println("<br><br>");
		//pw.println("Email-id: <br>");
		pw.println("<input type='text' placeholder='Email-id' name='emailid'>");
		pw.println("<br><br>");
		//pw.println("Password: <br>");
		pw.println("<input type='password' placeholder='Password' name='password'>");
		pw.println("<br><br>");
		//pw.println("Comfirm Password: <br>");
		pw.println("<input type='password' placeholder='Confirm Password' name='confirmpsw'>");
		pw.println("<br><br>");
		pw.println("<input style='padding:5px;' type='submit' value='SIGN UP FOR IMDB'>");
		pw.println("</form>");
		pw.println("</fieldset>");
		pw.println("</div>");
		pw.println("</body");
		pw.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
