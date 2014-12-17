package com.townscript.imdb.service.comment;
import java.util.List;

import com.townscript.imdb.model.Comment;



public interface CommentService {
	public int addcomment(Comment comment);
	public List<Comment> loadallcomment(int moviId);

}
