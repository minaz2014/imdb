package com.townscript.imdb.dao.movie;

//import java.sql.Blob;
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
import com.townscript.imdb.model.Movi;
import com.townscript.imdb.model.MoviRowMapper;

public class MoviDaoImpl implements MoviDao {

	@Override
	public int addmovi(final Movi movi) {
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
			"INSERT INTO MOVIE(MOVIE_NAME,DIRECTOR,CAST,CREATOR,DESCRIPTION,PHOTO) VALUES ('"+movi.getMoviname()+"','"+movi.getDirector()+
					"','"+movi.getCast()+"','"+movi.getCreator()+"','"+movi.getDescription()+"','"+movi.getPhoto()+"');", Statement.RETURN_GENERATED_KEYS);
                    return ps;
				}
			}, holder);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return holder.getKey().intValue();
	}

	@Override
	public List<Movi> loadallmovi() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setDatabaseName("imdb_db");
		dataSource.setUser("root");
		dataSource.setPassword("boxmarker");
		dataSource.setServerName("localhost");
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
	
		String sql = "SELECT * FROM MOVIE";
		List<Movi> movies=		jdbc.query(sql, new MoviRowMapper());
		
		return movies;
		}
	public Movi loadmovi(int moviId) {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setDatabaseName("imdb_db");
		dataSource.setUser("root");
		dataSource.setPassword("boxmarker");
		dataSource.setServerName("localhost");
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
	
	     String sql = "SELECT * FROM MOVIE WHERE MOVIE_ID = ?";
	     Movi movi = jdbc.queryForObject(
					sql, new Object[] {moviId  }, new MoviRowMapper());
	     return movi;
	}

	
	/*public int delmovi(Movi movi) {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setDatabaseName("imdb_db");
		dataSource.setUser("root");
		dataSource.setPassword("boxmarker");
		dataSource.setServerName("localhost");
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		int id = 0;
		try {
			
			id = jdbc.update("DELETE FROM MOVIE(MOVIE_NAME,DIRECTOR,CAST,CREATOR) VALUES ('"+movi.getMoviname()+"','"+movi.getDirector()+
					"','"+movi.getCast()+"','"+movi.getCreator()+"',null);");
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		return id;
	}*/

	@Override
	public void delmovi(int moviId) {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setDatabaseName("imdb_db");
		dataSource.setUser("root");
		dataSource.setPassword("boxmarker");
		dataSource.setServerName("localhost");
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		String sql = "DELETE FROM MOVIE WHERE MOVIE_ID = "+moviId;
		jdbc.update(sql);
//	    Movi movi = jdbc.queryForObject(
//					sql, new Object[] {moviId}, new MoviRowMapper());
	    // return movi;

		}

	@Override
	public int editmovi(Movi movi) {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setDatabaseName("imdb_db");
		dataSource.setUser("root");
		dataSource.setPassword("boxmarker");
		dataSource.setServerName("localhost");
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		int id = 0;
		try {
			
			id = jdbc.update("UPDATE MOVIE SET MOVIE_NAME= '"+movi.getMoviname()+"', DIRECTOR= '"+movi.getDirector()+"', CAST= '"+movi.getCast()+"', CREATOR= '"+movi.getCreator()+"', DESCRIPTION= '"+movi.getDescription()+"' WHERE MOVIE_ID= '"+movi.getId()+"';");
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return id;

	}


	
	/*public Blob setImage(Movi movi,Blob image) {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setDatabaseName("imdb_db");
		dataSource.setUser("root");
		dataSource.setPassword("boxmarker");
		dataSource.setServerName("localhost");
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		int id = 0;
		try {
			//Movi movi;
			id = jdbc.update("INSERT INTO MOVI(MOVIE_NAME," +
					"DIRECTOR,CAST,CREATOR) VALUES ('"+movi.getMoviname()+"','"+movi.getDirector()+
					"','"+movi.getCast()+"','"+movi.getCreator()+"','"+movi.getImage()+"');");
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return image;
		
	}*/


	
	}

