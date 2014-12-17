package com.townscript.imdb.service.movie;

//import java.sql.Blob;
import java.util.List;

import com.townscript.imdb.dao.movie.MoviDao;
import com.townscript.imdb.dao.movie.MoviDaoImpl;
import com.townscript.imdb.model.Movi;

public class MoviServiceImpl implements MoviService {

	@Override
	public int addmovi(Movi movi) {
		MoviDao moviDao = new MoviDaoImpl();
		return moviDao.addmovi(movi);
		}

	@Override
	public List<Movi> loadallmovi() {
		MoviDao moviDao = new MoviDaoImpl();
		return moviDao.loadallmovi();
		
		}

	@Override
	public Movi loadmovi(int moviId) {
		MoviDao moviDao = new MoviDaoImpl();
		return moviDao.loadmovi(moviId);
	}

	@Override
	public void delmovi(int moviId) {
		MoviDao moviDao = new MoviDaoImpl();
        moviDao.delmovi(moviId);
	
	}


	public int editmovi(Movi movi) {
		MoviDao moviDao = new MoviDaoImpl();
		return moviDao.editmovi(movi);
	
	}
	
	/*public Movi setImage(Movi movi,Blob image){
		MoviDao moviDao = new MoviDaoImpl();
        return moviDao.setImage(movi, image);
	}*/

}
