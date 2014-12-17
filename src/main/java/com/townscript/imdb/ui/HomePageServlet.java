package com.townscript.imdb.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.townscript.imdb.model.Movi;
import com.townscript.imdb.service.movie.MoviService;
import com.townscript.imdb.service.movie.MoviServiceImpl;

/**
 * Servlet implementation class homepage
 */
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	PrintWriter pw = response.getWriter();
	HttpSession session=request.getSession();  
    Integer id = (Integer) session.getAttribute("userid"); 
    String username = (String) session.getAttribute("username"); 
   if(id==null) 
   {
	   response.sendRedirect("/imdb/login");
	   return;
   }	
	
	pw.println("<html>");
	
	pw.println("<head>");
	

	pw.println("<link rel='stylesheet' href='/imdb/css/homepage.css'>");
	pw.println("<script src='/imdb/js/homepage.js'></script>");
	pw.println("</head>");
	pw.println("<body>");
	pw.println("<div id='header' align='center'>");
	pw.println("<h1>Movie List</h1>");
	pw.println("<h2>Welcome "+username+"</h2>");
    pw.println("<a class='topcorner' href='javascript:logout();'>Sign out</a>");
    pw.println("<br><br>");
    pw.println("<button style='padding:5px;' onclick='newMovi()'>ADD A NEW MOVIE");
    pw.println("</button");
	pw.println("</div>");

	MoviService moviService = new MoviServiceImpl();
	List<Movi> movies = moviService.loadallmovi();
    pw.println("<div id='section'>");
    
    for (Movi movi : movies) {
    	pw.println("<div onclick='onMoviclick("+movi.getId()+");' class='movie-block'>");
    	pw.println("<img src = '"+movi.getPhoto()+"'></img>");
    	pw.println("<h3>"+movi.getMoviname()+"</h3>");
    	//pw.println("<a href="/imdb/user/moviepage">moviname()");
    	pw.println("<p>"+movi.getCreator()+"</p>");
    	pw.println("</div>");
    	
	}
    

    pw.println("</div>");

	/*pw.println("<div align='center'>");
	pw.println("<fieldset>");
	pw.println("<form>ovie");
	pw.println("<h1>HOME PAGE</h1>");
	pw.println("<p>You are successfully logged in!</p>");

    //pw.println("<a href='javascript:logout();'>Sign out</a>");
	pw.println("</form>");
	pw.println("</fieldset>");
	pw.println("</div>");*/
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
