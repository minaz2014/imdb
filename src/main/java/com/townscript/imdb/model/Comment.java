package com.townscript.imdb.model;

public class Comment {
	private int id;
	private String comment;
	private String creator;
	private int moviId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public int getMoviId() {
		return moviId;
	}
	public void setMoviId(int moviId) {
		this.moviId = moviId;
	}
	
}
