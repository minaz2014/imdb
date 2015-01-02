package com.townscript.imdb.ui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.townscript.imdb.model.Comment;
import com.townscript.imdb.service.comment.CommentService;
import com.townscript.imdb.service.comment.CommentServiceImpl;


/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getRequestURI().equals("/imdb/comment/add")) {
			String comments = request.getParameter("comments");
			String creator = request.getParameter("creator");
			//Integer moviId = request.getParameter("movieId");
			int moviId = Integer.parseInt(request.getParameter("movieId"));
			//Blob image = request.getParameter("image");
			Comment comment = new Comment();
			comment.setComment(comments);
			comment.setCreator(creator);
			comment.setMoviId(moviId);
			CommentService commentService = new CommentServiceImpl();
			//movi.setImage(image);
			int id = commentService.addcomment(comment);                                  

		}

	}
	
	
}
