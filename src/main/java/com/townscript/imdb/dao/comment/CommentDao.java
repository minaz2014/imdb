package com.townscript.imdb.dao.comment;

import java.util.List;

import com.townscript.imdb.model.Comment;

public interface CommentDao {
	public int addcomment(Comment comment);
	public List<Comment> loadallcomment(int moviId);


}
