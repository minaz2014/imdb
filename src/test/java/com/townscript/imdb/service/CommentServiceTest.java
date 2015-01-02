package com.townscript.imdb.service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.townscript.imdb.JdbcTemplateFactory;
import com.townscript.imdb.model.Comment;
import com.townscript.imdb.model.CommentsRowMapper;
import com.townscript.imdb.model.Movi;
import com.townscript.imdb.model.MoviRowMapper;
import com.townscript.imdb.service.comment.CommentService;
import com.townscript.imdb.service.comment.CommentServiceImpl;
import com.townscript.imdb.service.movie.MoviService;
import com.townscript.imdb.service.movie.MoviServiceImpl;

import static org.junit.Assert.*;



public class CommentServiceTest {
	private JdbcTemplate jdbcTemplate = JdbcTemplateFactory.getInstance();

	@Before
	public void clearDbBeforeTest() {
		clear();
	}
	
	@After
	public void clearDbAfterTest() {
		clear();
	}
	
	private void clear() {
		jdbcTemplate.update("DELETE FROM COMMENTS");
	}
	
	@Test
    public void testAddCommentService(){
        Comment comment = new Comment();
        comment.setComment("good");
        comment.setCreator("Minaz");
        comment.setMoviId(12);
        CommentService commentservice = new CommentServiceImpl();
		int id = commentservice.addcomment(comment);
		
           String sql = "SELECT * FROM COMMENTS WHERE COMMENT_ID = ?";
		
		Comment loadComment = jdbcTemplate.queryForObject(
				sql, new Object[] { id }, new CommentsRowMapper());
		
		assertEquals(comment.getComment(), loadComment.getComment());
		assertEquals(comment.getCreator(), loadComment.getCreator());
		assertEquals(comment.getMoviId(), loadComment.getMoviId());
        
	}
   
	@Test
	public void testloadallcomment(){
		jdbcTemplate.update("INSERT INTO COMMENTS(COMMENT,CREATOR,MOVIE_ID) VALUES('BORE','MINAZ','14');");
		jdbcTemplate.update("INSERT INTO COMMENTS(COMMENT,CREATOR,MOVIE_ID) VALUES('GOOD','ASHISH','14');");
		jdbcTemplate.update("INSERT INTO COMMENTS(COMMENT,CREATOR,MOVIE_ID) VALUES('BAD','ROHAN','16');");
		
		CommentService commentService = new CommentServiceImpl();
		List<Comment> comment= commentService.loadallcomment(14);
		assertEquals(2, comment.size());
		
	}
	@Test
	public void testspecialchar(){
		Comment comment = new Comment();
        comment.setComment("good's");
        comment.setCreator("Minaz's");
        comment.setMoviId(12);
        CommentService commentservice = new CommentServiceImpl();
		int id = commentservice.addcomment(comment);
		
           String sql = "SELECT * FROM COMMENTS WHERE COMMENT_ID = ?";
		
		Comment loadComment = jdbcTemplate.queryForObject(
				sql, new Object[] { id }, new CommentsRowMapper());
		
		assertEquals(comment.getComment(), loadComment.getComment());
		assertEquals(comment.getCreator(), loadComment.getCreator());
		assertEquals(comment.getMoviId(), loadComment.getMoviId());
	}
}






