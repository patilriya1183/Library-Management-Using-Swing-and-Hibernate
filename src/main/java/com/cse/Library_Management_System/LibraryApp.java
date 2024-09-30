package com.cse.Library_Management_System;

public class LibraryApp {
    public static void main(String[] args) {
        IssueBookDAO issueBookDAO = new IssueBookDAO();

        // Issue a book to a user
        boolean issued = issueBookDAO.issueBook(1, 101, "2024-09-01", "2024-09-10");
        if (issued) {
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Failed to issue the book.");
        }

        // Return the book
        boolean returned = issueBookDAO.returnBook(1, 101);
        if (returned) {
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Failed to return the book.");
        }
    }
}
