package com.townscript.imdb.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CommentsRowMapper implements RowMapper<Comment> {

	@Override
	public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
		Comment comment = new Comment();
		comment.setId(rs.getInt("COMMENT_ID"));
		comment.setComment(rs.getString("COMMENT"));
		comment.setCreator(rs.getString("CREATOR"));
		comment.setMoviId(rs.getInt("MOVIE_ID"));	
		
		return comment;
	}

}
