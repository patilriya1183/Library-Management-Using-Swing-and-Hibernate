package com.cse.Library_Management_System;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class HistoryBook {
	@Id
	private int bookid;
	private String bookName;
	private String username;
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
