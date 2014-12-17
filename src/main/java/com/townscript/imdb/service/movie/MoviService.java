package com.townscript.imdb.service.movie;

//import java.sql.Blob;
import java.util.List;

import com.townscript.imdb.model.Movi;

public interface MoviService {
	
	public int addmovi(Movi movi);
    public List<Movi> loadallmovi();
    public Movi loadmovi(int moviId);
    public void delmovi(int moviId);
	public int editmovi(Movi movi);
    //public Movi setImage(Movi movi,Blob image);

}
