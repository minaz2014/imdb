package com.townscript.imdb.ui;

import java.io.IOException;
//import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.townscript.imdb.model.Movi;
import com.townscript.imdb.service.movie.MoviService;
import com.townscript.imdb.service.movie.MoviServiceImpl;


@WebServlet("/Movi")
public class MoviServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoviServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getRequestURI().equals("/imdb/movi/delete")){
			
		MoviService moviService = new MoviServiceImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		moviService.delmovi(id);
		
		response.sendRedirect("/imdb/homepage");
	
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getRequestURI().equals("/imdb/movi/add")) {
			String moviName = request.getParameter("moviename");
			String photo = request.getParameter("photo");
			String director = request.getParameter("director");
			String cast = request.getParameter("cast");
			String creator = request.getParameter("creator");
			String description = request.getParameter("description");
			//String image = request.getParameter("image");
			MoviService moviService = new MoviServiceImpl();
			Movi movi = new Movi();
			movi.setMoviname(moviName);
			movi.setDirector(director);
			movi.setCast(cast);
			movi.setCreator(creator);
			movi.setDescription(description);
			movi.setPhoto(photo);
			int id = moviService.addmovi(movi);                                  

			response.sendRedirect("/imdb/homepage");
		}
		if(request.getRequestURI().equals("/imdb/movi/edit")) {
			int id = Integer.parseInt(request.getParameter("moviId"));
			String moviName = request.getParameter("moviename");
			String director = request.getParameter("director");
			String cast = request.getParameter("cast");
			String creator = request.getParameter("creator");
			String description = request.getParameter("description");
			String photo = request.getParameter("photo");
			MoviService moviService = new MoviServiceImpl();
			Movi movi = new Movi();
			movi.setId(id);
			movi.setMoviname(moviName);
			movi.setDirector(director);
			movi.setCast(cast);
			movi.setCreator(creator);
			movi.setDescription(description);
			movi.setPhoto(photo);
			 id = moviService.editmovi(movi);                                  

			response.sendRedirect("/imdb/movipage?id="+movi.getId());
		}


	}

}
