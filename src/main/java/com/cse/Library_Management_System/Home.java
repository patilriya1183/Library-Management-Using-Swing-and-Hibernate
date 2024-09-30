package com.cse.Library_Management_System;
import java.awt.*;

//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class Home {
//    static JFrame mainFrame = new JFrame("Library Management System");
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            mainFrame.setSize(800, 600);
//            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            mainFrame.setLocationRelativeTo(null);
//            mainFrame.setLayout(new BorderLayout());
//
//            // Create a CardLayout for switching panels
//            JPanel cardPanel = new JPanel(new CardLayout());
//
//            // Create the Home, Signup, and Login panels
//            JPanel homePanel = createHomePanel();
//            JPanel signupPanel = createSignupPanel();
//            JPanel loginPanel = createLoginPanel();
//
//            cardPanel.add(homePanel, "Home");
//            cardPanel.add(signupPanel, "Signup");
//            cardPanel.add(loginPanel, "Login");
//
//            // Create a panel for buttons
//            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
//            buttonPanel.setBackground(Color.white);
//
//            // Create Home, Signup, and Login buttons
//            JButton homeButton = createStyledButton("Home");
//            JButton signupButton = createStyledButton("Signup");
//            JButton loginButton = createStyledButton("Login");
//
//            // Add action listeners to switch between panels
//            homeButton.addActionListener(e -> switchPanel(cardPanel, "Home"));
//            signupButton.addActionListener(e -> switchPanel(cardPanel, "Signup"));
//            loginButton.addActionListener(e -> switchPanel(cardPanel, "Login"));
//
//            // Add buttons to the button panel
//            buttonPanel.add(homeButton);
//            buttonPanel.add(signupButton);
//            buttonPanel.add(loginButton);
//
//            // Add button panel at the top and card panel in the center
//            mainFrame.add(buttonPanel, BorderLayout.NORTH);
//            mainFrame.add(cardPanel, BorderLayout.CENTER);
//
//            mainFrame.setVisible(true);
//        });
//    }
//
//    // Method to switch panels in CardLayout
//    private static void switchPanel(JPanel cardPanel, String panelName) {
//        CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
//        cardLayout.show(cardPanel, panelName);
//    }
//
//    // Home section with a button
//    private static JPanel createHomePanel() {
//        JPanel homePanel = new JPanel();
//        homePanel.setLayout(new BorderLayout());
//        homePanel.setBackground(Color.WHITE);
//
//        // Add a welcome header
//        JLabel headerLabel = createStyledLabel("Welcome to Library Management System", 28, Font.BOLD, Color.WHITE);
//        JPanel headerPanel = new JPanel();
//        headerPanel.setBackground(new Color(72, 61, 139));
//        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
//        headerPanel.add(headerLabel);
//        homePanel.add(headerPanel, BorderLayout.NORTH);
//
//     
//     // Add an image
//        ImageIcon scaledImageIcon = null;
//        try {
//            // Load image from resources using getResource
//            ImageIcon originalImageIcon = new ImageIcon(Home.class.getResource("/library_image.jpg"));
//            Image originalImage = originalImageIcon.getImage();
//            Image scaledImage = originalImage.getScaledInstance(550, 400, Image.SCALE_SMOOTH);
//            scaledImageIcon = new ImageIcon(scaledImage);
//        } catch (Exception e) {
//            System.out.println("Image not found: " + e.getMessage());
//        }
//
//        // Display image if loaded successfully
//        if (scaledImageIcon != null) {
//            JLabel homeImage = new JLabel(scaledImageIcon);
//            homeImage.setHorizontalAlignment(SwingConstants.CENTER);
//            homePanel.add(homeImage, BorderLayout.CENTER);
//        } else {
//            // Fallback in case image doesn't load
//            JLabel errorLabel = new JLabel("Image not available", SwingConstants.CENTER);
//            errorLabel.setFont(new Font("Arial", Font.BOLD, 18));
//            homePanel.add(errorLabel, BorderLayout.CENTER);
//        }
//
//
//
//        return homePanel;
//        
//        
//    }
//
//    // Signup section
//    private static JPanel createSignupPanel() {
//        JPanel signupPanel = new JPanel();
//        signupPanel.setLayout(new BorderLayout());
//        signupPanel.setBackground(Color.WHITE);
//
//        // Add registration form
//        RegistrationUI registrationUI = new RegistrationUI();
//        signupPanel.add(registrationUI.getMainPanel(), BorderLayout.CENTER);
//
//        return signupPanel;
//    }
//
//    // Login section
//    private static JPanel createLoginPanel() {
//        JPanel loginPanel = new JPanel();
//        loginPanel.setLayout(new BorderLayout());
//        loginPanel.setBackground(Color.WHITE);
//
//        // Add login form
//        Login librarySignupLoginGUI = new Login();
//        loginPanel.add(librarySignupLoginGUI.getMainPanel(), BorderLayout.CENTER);
//
//        return loginPanel;
//    }
//
//    // Function to create consistent styled labels
//    private static JLabel createStyledLabel(String text, int fontSize, int style, Color color) {
//        JLabel label = new JLabel(text);
//        label.setFont(new Font("Arial", style, fontSize));
//        label.setForeground(color);
//        label.setHorizontalAlignment(SwingConstants.CENTER);
//        return label;
//    }
//
//    // Function to create consistent styled buttons
//    private static JButton createStyledButton(String text) {
//        JButton button = new JButton(text);
//        button.setFont(new Font("Arial", Font.BOLD, 14));
//        button.setBackground(new Color(72, 61, 139)); // Dark blue background
//        button.setForeground(Color.WHITE); // White text
//        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Padding
//        button.setFocusPainted(false);
//        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor on hover
//        return button;
//    }
//}








import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {
    static JFrame mainFrame = new JFrame("Library Management System");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            mainFrame.setSize(800, 600);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setLayout(new BorderLayout());

            // Create a CardLayout for switching panels
            JPanel cardPanel = new JPanel(new CardLayout());

            // Create the Home, Signup, and Login panels
            JPanel homePanel = createHomePanel();
            JPanel signupPanel = createSignupPanel();
            JPanel loginPanel = createLoginPanel();

            cardPanel.add(homePanel, "Home");
            cardPanel.add(signupPanel, "Signup");
            cardPanel.add(loginPanel, "Login");

            // Create a panel for buttons
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
            buttonPanel.setBackground(Color.white);

            // Create Home, Signup, and Login buttons
            JButton homeButton = createStyledButton("Home");
            JButton signupButton = createStyledButton("Signup");
            JButton loginButton = createStyledButton("Login");

            // Add action listeners to switch between panels
            homeButton.addActionListener(e -> switchPanel(cardPanel, "Home"));
            signupButton.addActionListener(e -> switchPanel(cardPanel, "Signup"));
            loginButton.addActionListener(e -> switchPanel(cardPanel, "Login"));

            // Add buttons to the button panel
            buttonPanel.add(homeButton);
            buttonPanel.add(signupButton);
            buttonPanel.add(loginButton);

            // Add button panel at the top and card panel in the center
            mainFrame.add(buttonPanel, BorderLayout.NORTH);
            mainFrame.add(cardPanel, BorderLayout.CENTER);

            mainFrame.setVisible(true);
        });
    }

    // Method to switch panels in CardLayout
    private static void switchPanel(JPanel cardPanel, String panelName) {
        CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
        cardLayout.show(cardPanel, panelName);
    }

    // Home section with a button
    private static JPanel createHomePanel() {
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new BorderLayout());
        homePanel.setBackground(Color.WHITE);

        // Add a welcome header
        JLabel headerLabel = createStyledLabel("Welcome to Library Management System", 28, Font.BOLD, Color.WHITE);
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(72, 61, 139));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        headerPanel.add(headerLabel);
        homePanel.add(headerPanel, BorderLayout.NORTH);

        // Add an image
        ImageIcon originalImageIcon = new ImageIcon("library_image.jpg");
        Image originalImage = originalImageIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(550, 400, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        JLabel homeImage = new JLabel(scaledImageIcon);
        homeImage.setHorizontalAlignment(SwingConstants.CENTER);
        homePanel.add(homeImage, BorderLayout.CENTER);

        return homePanel;
    }

    // Signup section
    private static JPanel createSignupPanel() {
        JPanel signupPanel = new JPanel();
        signupPanel.setLayout(new BorderLayout());
        signupPanel.setBackground(Color.WHITE);

        // Add registration form
        RegistrationUI registrationUI = new RegistrationUI();
        signupPanel.add(registrationUI.getMainPanel(), BorderLayout.CENTER);

        return signupPanel;
    }

    // Login section
    private static JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BorderLayout());
        loginPanel.setBackground(Color.WHITE);

        // Add login form
        Login librarySignupLoginGUI = new Login();
        loginPanel.add(librarySignupLoginGUI.getMainPanel(), BorderLayout.CENTER);

        return loginPanel;
    }

    // Function to create consistent styled labels
    private static JLabel createStyledLabel(String text, int fontSize, int style, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", style, fontSize));
        label.setForeground(color);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }

    // Function to create consistent styled buttons
    private static JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(72, 61, 139)); // Dark blue background
        button.setForeground(Color.WHITE); // White text
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Padding
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor on hover
        return button;
    }
}