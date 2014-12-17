
package com.townscript.imdb.model;

//import java.sql.Blob;

/**
 * @author Townscript
 *
 */
public class Movi {
	private int id;
	private String moviname;
	private String director;
	private String cast;
	private String creator;
	private String description;
	private String photo;
	//private String comments;
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
		
	}
	public String getMoviname() {
		return moviname;
	}
	public void setMoviname(String moviname) {
		this.moviname = moviname;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}

	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}


	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

   
	
	public String getPhoto() {
		return photo;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo ;
		
	}

	

}
