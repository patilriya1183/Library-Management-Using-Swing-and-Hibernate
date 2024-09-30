package com.cse.Library_Management_System;



import javax.swing.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    private JPanel mainPanel;
    private Configuration con;

    public Login() {
        // Set up the frame
        setTitle("Library Management System - Login");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the login panel
        mainPanel = createLoginPanel();

        // Add the panel to the frame
        add(mainPanel);
    }

    // Custom function to style JButtons
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(72, 61, 139)); // Dark blue background
        button.setForeground(Color.WHITE); // White text
        button.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15)); // Padding
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor on hover
        return button;
    }

    // Custom function to create JLabels with consistent font styling
    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setForeground(new Color(60, 60, 60)); // Dark grey text
        return label;
    }

    // Login Panel
    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        loginPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel lblTitle = new JLabel("Login", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setForeground(new Color(72, 61, 139)); // Title color
        gbc.gridwidth = 2;
        loginPanel.add(lblTitle, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        JLabel lblUsername = createStyledLabel("Email:");
        loginPanel.add(lblUsername, gbc);

        gbc.gridx = 1;
        JTextField txtUsername = new JTextField();
        txtUsername.setPreferredSize(new Dimension(200, 30));  // Set width to 200 and height to 30
        txtUsername.setFont(new Font("Arial", Font.PLAIN, 14));
        loginPanel.add(txtUsername, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblPassword = createStyledLabel("Password:");
        loginPanel.add(lblPassword, gbc);

        gbc.gridx = 1;
        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setPreferredSize(new Dimension(200, 30));  // Set width to 200 and height to 30
        txtPassword.setFont(new Font("Arial", Font.PLAIN, 14));
        loginPanel.add(txtPassword, gbc);
        
        // Add role dropdown after the password field
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblRole = createStyledLabel("Select Role:");
        loginPanel.add(lblRole, gbc);

        gbc.gridx = 1;
        // Add a dropdown for role selection (Admin or User)
        String[] roles = {"User", "Admin"};
        JComboBox<String> roleDropdown = new JComboBox<>(roles);
        roleDropdown.setPreferredSize(new Dimension(200, 30));
        roleDropdown.setFont(new Font("Arial", Font.PLAIN, 14));
        loginPanel.add(roleDropdown, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        JButton btnLogin = createStyledButton("Login");
        loginPanel.add(btnLogin, gbc);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String role = (String) roleDropdown.getSelectedItem();
            	
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());
                

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields are required", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!username.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    JOptionPane.showMessageDialog(null, "Invalid email format", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (password.length() < 8) {
                    JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                	
                	if(role.equals("Admin")) {
                		Configuration con = new Configuration().configure().addAnnotatedClass(Admin.class);
                		SessionFactory sf = con.buildSessionFactory();
	                    Session s = sf.openSession();
	                    Transaction tx = s.beginTransaction();
	                    
	                    Admin ad = (Admin) s.get(Admin.class, username);
	                    
	                    if(ad != null) {
	                    	System.out.println(password);
	                    	if(password.equals(ad.getPassword())) {
	                    		
	                    		JOptionPane.showMessageDialog(Login.this, "Admin login successfully");
	                    		AdminUI adminUI = new AdminUI();
	                            adminUI.setVisible(true);
	                            Login.this.setVisible(false);
	                    		
	                    	} else {
	                    		JOptionPane.showMessageDialog(null, "Admin wrong password", "Error", JOptionPane.ERROR_MESSAGE);
	                    	}
	                    	
	                    } else {
	                    	JOptionPane.showMessageDialog(null, "Admin doesn't exists", "Error", JOptionPane.ERROR_MESSAGE);
	                    }
	                    
	                    tx.commit();
                	} else {
                		Configuration con = new Configuration().configure().addAnnotatedClass(Students.class);
                		SessionFactory sf = con.buildSessionFactory();
	                    Session s = sf.openSession();
	                    Transaction tx = s.beginTransaction();
	                    
	                    Students st = (Students) s.get(Students.class, username);
	                    
	                    if(st != null) {
	                    	if(password.equals(st.getStudentPassword())) {
	                    		JOptionPane.showMessageDialog(Login.this, "Student login successfully");
	                    		new LibraryProfileView(st).setVisible(true);
	                    		Login.this.setVisible(false);
	                    		
	                    	} else {
	                    		JOptionPane.showMessageDialog(null, "Incorrect password", "Error", JOptionPane.ERROR_MESSAGE);
	                    	}
	                    	
	                    } else {
	                    	JOptionPane.showMessageDialog(null, "User doesn't exists", "Error", JOptionPane.ERROR_MESSAGE);
	                    }
	                    
	                    tx.commit();
                	}
                    
                    
                }
            }
        });

        return loginPanel;
    }
    
    public JPanel getMainPanel() {
        return mainPanel;
    }

    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Login gui = new Login();
                gui.setVisible(true);
            }
        });
    }
}
