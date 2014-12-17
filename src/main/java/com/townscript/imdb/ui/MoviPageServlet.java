package com.townscript.imdb.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.townscript.imdb.model.Comment;
import com.townscript.imdb.model.Movi;
import com.townscript.imdb.service.comment.CommentServiceImpl;
import com.townscript.imdb.service.movie.MoviService;
import com.townscript.imdb.service.movie.MoviServiceImpl;

/**
 * Servlet implementation class MoviePageServlet
 */
@WebServlet("/MoviePage")
public class MoviPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoviPageServlet() {
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
	   
	   int moviId = Integer.parseInt(request.getParameter("id"));
	   MoviService moviService = new MoviServiceImpl();
	   Movi movi=moviService.loadmovi(moviId);
	   
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<link rel='stylesheet' href='/imdb/css/homepage.css'>");
		pw.println("<script src='/imdb/js/createnewpage.js'></script>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<div id='header' align='center'>");
		pw.println("<h1>"+movi.getMoviname()+"</h1>");
		pw.println("<p>DIR:"+movi.getDirector()+"</p>");
    	pw.println("<p>WITH:"+movi.getCast()+"</p>");
    	pw.println("<p>CRITIC:"+movi.getCreator()+"</p>"); 
    	pw.println("<p>DESCRIPTION:"+movi.getDescription()+"</p>"); 
    	pw.println("<img src = '"+movi.getPhoto()+"'></img>");
    	pw.println("</div>");
		pw.println("<div align='center'>");
        pw.println("<br><br>");
		pw.println("<div align='left' style= width:60%>");
        pw.println("<p>COMMENTS:</p>");
        pw.println("<br>");
        pw.println("<div id='comments' style='background-color:paleturquoise';>");
        
        List<Comment> comments = new CommentServiceImpl().loadallcomment(moviId);
        String colorclass="";
        int count = 1;
        for (Comment comment : comments) {
        	if(count%2==0){
        		colorclass="light";
        	}
        	else{
        		colorclass="dark";
        	}
        	count++;
        
        	pw.println("<div class= "+colorclass+" style='margin:5px;'><strong>"+comment.getCreator()+": </strong>"+comment.getComment()+"</div>");
		}
        
        
        pw.println("</div>");
		pw.println("<textarea id='commentbox' placeholder='Write comment' style= width:50%></textarea>");
        pw.println("<br>");
		pw.println("<button style='padding:px;' onclick=\"postcomment('"+username+"',"+moviId+")\">Post</button>");
        pw.println("</div>");
    	if(movi.getCreator().equals(username)){
	    pw.println("<a class='topcorner1' href='/imdb/movi/delete?id="+moviId+"'>Delete review</a>");
	    pw.println("<a class='topcorner2' href='/imdb/createnewpage?show=edit&id="+moviId+"'>Edit review</a>");
    	}
    	pw.println("<a class= 'topcorner3' href='/imdb/homepage'>Back to MovieList</a>");
	    pw.println("<a class='topcorner' href='javascript:logout();'>Sign out</a>");

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
