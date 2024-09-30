package com.cse.Library_Management_System;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RegistrationUI extends JFrame {
    private JPanel mainPanel;
    private JTextField studentIdField;
    private JTextField studentNameField;
    private JTextField studentBranchField;
    private JTextField emailField;
    private JPasswordField passwordField;
  
    public RegistrationUI() {
        // Set up the frame
        setTitle("Library Management System - Register");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the registration panel
        mainPanel = createRegistrationPanel();

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

    // Registration Panel
    private JPanel createRegistrationPanel() {
        JPanel registrationPanel = new JPanel();
        registrationPanel.setLayout(new GridBagLayout());
        registrationPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel lblTitle = new JLabel("Register", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setForeground(new Color(72, 61, 139)); // Title color
        gbc.gridwidth = 2;
        registrationPanel.add(lblTitle, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        JLabel lblStudentId = createStyledLabel("Student ID:");
        registrationPanel.add(lblStudentId, gbc);

        gbc.gridx = 1;
        studentIdField = new JTextField();
        studentIdField.setPreferredSize(new Dimension(200, 30)); // Set width to 200 and height to 30
        studentIdField.setFont(new Font("Arial", Font.PLAIN, 14));
        registrationPanel.add(studentIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblStudentName = createStyledLabel("Student Name:");
        registrationPanel.add(lblStudentName, gbc);

        gbc.gridx = 1;
        studentNameField = new JTextField();
        studentNameField.setPreferredSize(new Dimension(200, 30));
        studentNameField.setFont(new Font("Arial", Font.PLAIN, 14));
        registrationPanel.add(studentNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblStudentBranch = createStyledLabel("Student Branch:");
        registrationPanel.add(lblStudentBranch, gbc);

        gbc.gridx = 1;
        studentBranchField = new JTextField();
        studentBranchField.setPreferredSize(new Dimension(200, 30));
        studentBranchField.setFont(new Font("Arial", Font.PLAIN, 14));
        registrationPanel.add(studentBranchField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblEmail = createStyledLabel("Email:");
        registrationPanel.add(lblEmail, gbc);

        gbc.gridx = 1;
        emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(200, 30));
        emailField.setFont(new Font("Arial", Font.PLAIN, 14));
        registrationPanel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        JLabel lblPassword = createStyledLabel("Password:");
        registrationPanel.add(lblPassword, gbc);

        gbc.gridx = 1;
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 30));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        registrationPanel.add(passwordField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        JButton btnRegister = createStyledButton("Register");
        registrationPanel.add(btnRegister, gbc);

        // Register button action
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateForm()) {
                    String studentId = studentIdField.getText();
                    String studentName = studentNameField.getText();
                    String studentBranch = studentBranchField.getText();
                    String email = emailField.getText();
                    String password = new String(passwordField.getPassword());
                    
                    Configuration con = new Configuration().configure().addAnnotatedClass(Students.class);
                    SessionFactory sf = con.buildSessionFactory();
                    Session s = sf.openSession();
                    Transaction tx = s.beginTransaction();
                    
                    Students student = new Students();  // Assuming this is set
                    student.setStudentBranch(studentBranch);    // Assuming this is set
                    student.setStudentEmail(email);      // Ensure this is set
                    student.setStudentName(studentName);        // Assuming this is set
                    student.setStudentPassword(password); // Assuming this is set
                    student.setStudentId(studentId);            // Assuming this is set

                    s.beginTransaction();
                    s.save(student);
                    s.getTransaction().commit();
                    
                    JOptionPane.showMessageDialog(RegistrationUI.this, "Student Registered Successfully!");
                }
            }
        });
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        JButton btnCancel = createStyledButton("Cancel");
        registrationPanel.add(btnCancel, gbc);

        return registrationPanel;
    }

    private boolean validateForm() {
        if (studentIdField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Student ID is required.");
            return false;
        }
        if (studentNameField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Student Name is required.");
            return false;
        }
        if (studentBranchField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Student Branch is required.");
            return false;
        }
        if (emailField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email is required.");
            return false;
        }
        if (!isValidEmail(emailField.getText())) {
            JOptionPane.showMessageDialog(this, "Invalid email format.");
            return false;
        }
        if (passwordField.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Password is required.");
            return false;
        }
        if (passwordField.getPassword().length < 8) {
            JOptionPane.showMessageDialog(this, "Password must be at least 8 characters long.");
            return false;
        }
        return true;
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&-]+(?:\\.[a-zA-Z0-9_+&-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(email).matches();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RegistrationUI ui = new RegistrationUI();
            ui.setVisible(true);
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}



