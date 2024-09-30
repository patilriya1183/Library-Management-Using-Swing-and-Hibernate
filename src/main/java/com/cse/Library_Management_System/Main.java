package com.cse.Library_Management_System;

public class Main {
    public static void main(String[] args) {
        AdminDAO adminDAO = new AdminDAO();

        // Create a new Admin object
        Admin admin = new Admin();
        admin.setUsername("admin1@gmail.com");
        admin.setPassword("adminpass123");

        // Save the admin to the database
        adminDAO.saveAdmin(admin);

        // Retrieve the admin from the database
        Admin retrievedAdmin = adminDAO.getAdmin("admin1");
        if (retrievedAdmin != null) {
            System.out.println("Admin Username: " + retrievedAdmin.getUsername());
        }
    }
}
