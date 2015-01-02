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
import com.townscript.imdb.model.Movi;
import com.townscript.imdb.model.MoviRowMapper;
import com.townscript.imdb.service.movie.MoviService;
import com.townscript.imdb.service.movie.MoviServiceImpl;

import static org.junit.Assert.*;


public class MovieServiceTest {
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
		jdbcTemplate.update("DELETE FROM MOVIE");
	}
	
	@Test
	public void testAddMoviService(){
		Movi movi = new Movi();
		movi.setMoviname("Sholay's");
		movi.setDirector("Ramesh Sippy's");
		movi.setCast("Amitabh Bacchan, Dharmendra's");
		movi.setCreator("komal");
		movi.setDescription("Legendary!'s");
		movi.setPhoto("abc");
		MoviService moviservice = new MoviServiceImpl();
		int id = moviservice.addmovi(movi);
		
           String sql = "SELECT * FROM MOVIE WHERE MOVIE_ID = ?";
		
		Movi loadedMovi = jdbcTemplate.queryForObject(
				sql, new Object[] { id }, new MoviRowMapper());
		
		assertEquals(movi.getMoviname(), loadedMovi.getMoviname());
		assertEquals(movi.getDirector(), loadedMovi.getDirector());
		assertEquals(movi.getCast(), loadedMovi.getCast());
		assertEquals(movi.getCreator(), loadedMovi.getCreator());
		assertEquals(movi.getDescription(), loadedMovi.getDescription());
		assertEquals(movi.getPhoto(), loadedMovi.getPhoto());

		

	}
	
	@Test
	public void testloadallmovi(){
		jdbcTemplate.update("INSERT INTO MOVIE(MOVIE_NAME,DIRECTOR,CAST,CREATOR,DESCRIPTION,PHOTO) VALUES ('SHOLAY','ramesh sippy','Amit','komal','Legendary','abc');");
		jdbcTemplate.update("INSERT INTO MOVIE(MOVIE_NAME,DIRECTOR,CAST,CREATOR,DESCRIPTION,PHOTO) VALUES ('DABANG','Arbaaz Khan','Salman','minaz','great','def');");
		jdbcTemplate.update("INSERT INTO MOVIE(MOVIE_NAME,DIRECTOR,CAST,CREATOR,DESCRIPTION,PHOTO) VALUES ('RACE','Abbas Mastan','Saif','sanchit','good','ghi');");

		MoviService moviSerice = new MoviServiceImpl();
		List<Movi> movies= moviSerice.loadallmovi();
		assertEquals(3, movies.size());
		
	}

	@Test
	public void testdelmovi(){
		
		KeyHolder holder = new GeneratedKeyHolder();
	     
		try {
			jdbcTemplate.update(new PreparedStatementCreator(){
				
				@Override
                public PreparedStatement createPreparedStatement(Connection connection)
                        throws SQLException {
                    PreparedStatement ps = connection.prepareStatement("" +
			"INSERT INTO MOVIE(MOVIE_NAME,DIRECTOR,CAST,CREATOR,DESCRIPTION,PHOTO) VALUES ('SHOLAY','ramesh sippy','Amit','komal','Legendary','abc');", Statement.RETURN_GENERATED_KEYS);
                    return ps;
				}
			}, holder);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		MoviService moviSerice = new MoviServiceImpl();
        moviSerice.delmovi(holder.getKey().intValue());
        
        String sql = "SELECT * FROM MOVIE";
		List<Movi> movies=		jdbcTemplate.query(sql, new MoviRowMapper());
		assertEquals(0, movies.size());

}
	@Test
	public void testeditmovi(){
		
		KeyHolder holder = new GeneratedKeyHolder();
	     
		try {
			jdbcTemplate.update(new PreparedStatementCreator(){
				
				@Override
                public PreparedStatement createPreparedStatement(Connection connection)
                        throws SQLException {
                    PreparedStatement ps = connection.prepareStatement("" +
			"INSERT INTO MOVIE(MOVIE_NAME,DIRECTOR,CAST,CREATOR,DESCRIPTION,PHOTO) VALUES ('SHOLAY','ramesh sippy','Amit','komal','Legendary','abc');", Statement.RETURN_GENERATED_KEYS);
                    return ps;
				}
			}, holder);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		Movi movi = new Movi();
		movi.setId(holder.getKey().intValue());
		movi.setMoviname("kick");
		movi.setDirector("Sajid");
		movi.setCast("Salman");
		movi.setCreator("komal");
		movi.setDescription("bore");



		MoviService moviSerice = new MoviServiceImpl();
        moviSerice.editmovi(movi); 
        String sql = "SELECT * FROM MOVIE WHERE MOVIE_ID = ?";
	     Movi loadedmovi = jdbcTemplate.queryForObject(
					sql, new Object[] {movi.getId()  }, new MoviRowMapper());
	 
        
        assertEquals(movi.getMoviname(), loadedmovi.getMoviname());
        assertEquals(movi.getDirector(), loadedmovi.getDirector());
		assertEquals(movi.getCast(), loadedmovi.getCast());
		assertEquals(movi.getCreator(), loadedmovi.getCreator());
		assertEquals(movi.getDescription(), loadedmovi.getDescription());
		//assertEquals(movi.getPhoto(), loadedmovi.getPhoto());

	}
}