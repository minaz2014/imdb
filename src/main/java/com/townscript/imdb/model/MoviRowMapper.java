package com.townscript.imdb.model;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MoviRowMapper implements RowMapper<Movi> {

	@Override
	public Movi mapRow(ResultSet rs, int rowNum) throws SQLException {
		Movi movi = new Movi();
		movi.setId(rs.getInt("MOVIE_ID"));
		movi.setMoviname(rs.getString("MOVIE_NAME"));
		movi.setDirector(rs.getString("DIRECTOR"));
		movi.setCast(rs.getString("CAST"));
		movi.setCreator(rs.getString("CREATOR"));
		movi.setDescription(rs.getString("DESCRIPTION"));
		movi.setPhoto(rs.getString("PHOTO"));
	    
		return movi;
	}

	
}
