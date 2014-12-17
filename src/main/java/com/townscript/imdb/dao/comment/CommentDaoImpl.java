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

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.townscript.imdb.model.Comment;
import com.townscript.imdb.model.CommentsRowMapper;
import com.townscript.imdb.model.Movi;
import com.townscript.imdb.model.MoviRowMapper;

public class CommentDaoImpl implements CommentDao {

	@Override
	public int addcomment(final Comment comment) {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setDatabaseName("imdb_db");
		dataSource.setUser("root");
		dataSource.setPassword("boxmarker");
		dataSource.setServerName("localhost");
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
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
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setDatabaseName("imdb_db");
		dataSource.setUser("root");
		dataSource.setPassword("boxmarker");
		dataSource.setServerName("localhost");
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
	
		String sql = "SELECT * FROM COMMENTS WHERE MOVIE_ID = "+moviId;
	     
		List<Comment> comments =	jdbc.query(sql, new CommentsRowMapper());
		
		return comments;
		}

		
	}

