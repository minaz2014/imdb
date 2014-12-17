package com.townscript.imdb.ui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.townscript.imdb.model.Movi;
import com.townscript.imdb.service.movie.MoviService;
import com.townscript.imdb.service.movie.MoviServiceImpl;

@WebServlet("/CreateNewServlet")
public class CreateNewPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		HttpSession session=request.getSession();
		Integer id = (Integer) session.getAttribute("userid"); 
	    String username = (String) session.getAttribute("username"); 
		   if(id==null) 
		   {
			   response.sendRedirect("/imdb/login");
			   return;
		   }
		   

		String mode = request.getParameter("show");  
		   
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<link rel='stylesheet' href='/imdb/css/homepage.css'>");
		pw.println("<script src='/imdb/js/createnewpage.js'></script>");
		pw.println("</head>");
		
		pw.println("<body>");
		pw.println("<div align='centre'>");
		
		if(mode==null){
		
		pw.println("<h1>CREATE NEW REVIEW</h1>");
		pw.println("<fieldset>");
		pw.println("<legend>Upload photo</legend>");
		pw.println("<input type='file' name='photo' id='photo'>");
		pw.println("<button onclick='upload()'>upload</button>");
		pw.println("<form name='createnewpage' id = 'form' action = '/imdb/movi/add' onsubmit='return validateform()' method='post'>");
		pw.println("<input id='pic' type = 'hidden' name='photo'>");
		pw.println("<br><br>");
		pw.println("<input type='text' placeholder='Enter movie name' name='moviename'>");
		pw.println("<br><br>");
		pw.println("<input type='text' placeholder='Enter director name' name='director'>");
		pw.println("<br><br>");
		pw.println("<input type='text' placeholder='Enter cast' name='cast'>");
		pw.println("<br><br>");
		pw.println("<input type='text' placeholder='Enter your name' name='creator' value='"+username+"'>");
		pw.println("<br><br>");
		pw.println("<textarea name='description' form='form' placeholder='Write description'></textarea>");
		pw.println("<br><br>");
	    pw.println("<a class='topcorner' href='javascript:logout();'>Sign out</a>");
		pw.println("<br>");
		pw.println("<input style='padding:5px;' type='submit' value='SUBMIT'>");
		pw.println("</fieldset>");
		pw.println("</form>");
		}
		else{
			int moviId = Integer.parseInt(request.getParameter("id"));
	    MoviService moviservice = new MoviServiceImpl();
	    Movi movi = moviservice.loadmovi(moviId);
		pw.println("<form name='createnewpage' id = 'form' action = '/imdb/movi/edit' onsubmit='return validateform()' method='post'>");
		pw.println("<h1>CREATE NEW REVIEW</h1>");
		pw.println("<fieldset>");
		pw.println("<br><br>");
		pw.println("<input type='hidden' name='moviId' value='"+movi.getId()+"'>");
		pw.println("<input type='text' placeholder='Enter movie name' name='moviename' value='"+movi.getMoviname()+"'>");
		pw.println("<br><br>");
		pw.println("<input type='text' placeholder='Enter director name' name='director' value='"+movi.getDirector()+"'>");
		pw.println("<br><br>");
		pw.println("<input type='text' placeholder='Enter cast' name='cast' value='"+movi.getCast()+"'>");
		pw.println("<br><br>");
		pw.println("<input type='text' placeholder='Enter your name' name='creator' value='"+username+"'>");
		pw.println("<br><br>");
		pw.println("<textarea name='description' form='form' placeholder='Write description'>"+movi.getDescription()+"</textarea>");
		pw.println("<br><br>");
		pw.println("<a class='topcorner' href='javascript:logout();'>Sign out</a>");
		pw.println("<br><br>");
		pw.println("<input style='padding:5px;' type='submit' value='SUBMIT'>");
		pw.println("</fieldset>");
		pw.println("</form>");
			
			
		}
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
