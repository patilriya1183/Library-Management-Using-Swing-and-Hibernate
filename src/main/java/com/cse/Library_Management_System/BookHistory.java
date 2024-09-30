package com.cse.Library_Management_System;

public class BookHistory {
    private String bookName;
    private String bookId;
    private String issueDate;
    private String returnDate;

    // Constructor
    public BookHistory(String bookName, String bookId, String issueDate, String returnDate) {
        this.bookName = bookName;
        this.bookId = bookId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    // Getters
    public String getBookName() {
        return bookName;
    }

    public String getBookId() {
        return bookId;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }
}
