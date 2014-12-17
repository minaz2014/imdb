package com.townscript.imdb.dao.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.townscript.imdb.dao.JdbcTemplateFactory;
import com.townscript.imdb.model.Comment;
import com.townscript.imdb.model.CommentsRowMapper;

public class CommentDaoImpl implements CommentDao {

	@Override
	public int addcomment(final Comment comment) {
		
		JdbcTemplate jdbc = JdbcTemplateFactory.getInstance();
		//int id = 0;
		KeyHolder holder = new GeneratedKeyHolder();

		try {
               jdbc.update(new PreparedStatementCreator(){
				
				@Override
                public PreparedStatement createPreparedStatement(Connection connection)
                        throws SQLException {
                    PreparedStatement ps = connection.prepareStatement("" +			
			"INSERT INTO COMMENTS(COMMENT,CREATOR,MOVIE_ID) VALUES ('"+comment.getComment()+"','"+comment.getCreator()+
					"','"+comment.getMoviId()+"');", Statement.RETURN_GENERATED_KEYS);
               return ps;
		}
               }, holder);
               
		}catch (DataAccessException e) {
			e.printStackTrace();
		}
		return holder.getKey().intValue();
	}


	@Override
	public List<Comment> loadallcomment(int moviId) {
	
		JdbcTemplate jdbc = JdbcTemplateFactory.getInstance();
	
		String sql = "SELECT * FROM COMMENTS WHERE MOVIE_ID = "+moviId;
	     
		List<Comment> comments =	jdbc.query(sql, new CommentsRowMapper());
		
		return comments;
		}

		
	}

