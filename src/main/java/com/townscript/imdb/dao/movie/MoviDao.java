package com.townscript.imdb.dao.movie;
//import java.sql.Blob;
//import java.sql.Blob;
import java.util.List;

import com.townscript.imdb.model.Movi;


public interface MoviDao {
	
	public int addmovi(Movi movi);
    public List<Movi> loadallmovi();
    public Movi loadmovi(int moviId);
    public void delmovi(int moviId);
    public int editmovi(Movi movi);
   // public String setPhoto(String image);
    
}
