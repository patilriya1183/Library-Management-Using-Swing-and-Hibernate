package com.cse.Library_Management_System;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class IssueBook {
	@Id
	private String username;
	private String bookid;
	private String issueDate;
	private String returnDate;
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid2) {
		this.bookid = bookid2;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
