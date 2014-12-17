package com.townscript.imdb.service.comment;

import java.util.List;

import com.townscript.imdb.dao.comment.CommentDao;
import com.townscript.imdb.dao.comment.CommentDaoImpl;
import com.townscript.imdb.model.Comment;

public class CommentServiceImpl implements CommentService {

	@Override
	public int addcomment(Comment comment) {
		CommentDao commentDao = new CommentDaoImpl();
		return commentDao.addcomment(comment);
	}

	@Override
	public List<Comment> loadallcomment(int moviId) {
		CommentDao commentDao = new CommentDaoImpl();
        return commentDao.loadallcomment(moviId);
		
	}

}
