package com.cse.Library_Management_System;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AdminUI extends JFrame {

    private static final Configuration CONFIGURATION = new Configuration().configure().addAnnotatedClass(Books.class);
    private static final SessionFactory SESSION_FACTORY = CONFIGURATION.buildSessionFactory();

//    JButton btnHome = createStyledButton("Home");
//    registrationPanel.add(btnHome, gbc);
    
    private JTextField insertField1, insertField2, insertField3;
    private JTextField deleteField;
    private JTextField updateField1, updateField2;
    private JTextArea outputArea;
private JPanel mainPanel;
    public AdminUI() {
        setTitle("Library Management System - ADMIN");
        setSize(900, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel layout
         mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        // Title
        JLabel lblTitle = createStyledLabel("Library Management Operations", 24, new Color(72, 61, 139));
        gbc.gridy = 0;
        mainPanel.add(lblTitle, gbc);

        // Insert Panel
        JPanel insertPanel = createSectionPanel("Insert Book", new String[]{"Book Name:", "ISBN Number:", "Author Name:"});
        insertField1 = (JTextField) insertPanel.getComponent(1);
        insertField2 = (JTextField) insertPanel.getComponent(3);
        insertField3 = (JTextField) insertPanel.getComponent(5);
        JButton btnInsert = createStyledButton("Insert");
        insertPanel.add(btnInsert);
        gbc.gridy++;
        mainPanel.add(insertPanel, gbc);

   
        
        // Delete Panel
        JPanel deletePanel = createSectionPanel("Delete Book", new String[]{"Delete Book by ISBN:"});
        deleteField = (JTextField) deletePanel.getComponent(1);
        JButton btnDelete = createStyledButton("Delete");
        deletePanel.add(btnDelete);
        gbc.gridy++;
        mainPanel.add(deletePanel, gbc);

        // Update Panel
        JPanel updatePanel = createSectionPanel("Update Book", new String[]{"Update Book Name:", "ISBN Number (Mandatory):"});
        updateField1 = (JTextField) updatePanel.getComponent(1);
        updateField2 = (JTextField) updatePanel.getComponent(3);
        JButton btnUpdate = createStyledButton("Update");
        updatePanel.add(btnUpdate);
        gbc.gridy++;
        mainPanel.add(updatePanel, gbc);

        // View Panel
        JPanel viewPanel = new JPanel(new BorderLayout());
        viewPanel.setBorder(BorderFactory.createTitledBorder("View Books"));
        JButton btnView = createStyledButton("View Books");
        outputArea = new JTextArea(10, 50);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        viewPanel.add(btnView, BorderLayout.NORTH);
        viewPanel.add(scrollPane, BorderLayout.CENTER);
        gbc.gridy++;
        mainPanel.add(viewPanel, gbc);

        // Adding main panel to frame
        add(mainPanel);

        // Logout Button
        JButton btnLogout = createStyledButton("Logout");
        gbc.gridy++;
        
		mainPanel.add(btnLogout, gbc);
        add(mainPanel);
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	  JOptionPane.showMessageDialog(
            	            null,                             // Parent component (null for default)
            	            "You have been successfully logged out.", // Message
            	            "Logout Successful",              // Title of the dialog
            	            JOptionPane.INFORMATION_MESSAGE );
            	  dispose(); // close the current window
//                new HomeUI().setVisible(true); // open the home interface
            }
        });
        
        // Action Listeners
        btnInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Session session = SESSION_FACTORY.openSession();
                Transaction tx = session.beginTransaction();
                String bookName = insertField1.getText();
                int isbn = Integer.parseInt(insertField2.getText());
                String authorName = insertField3.getText();
                Books book = new Books();
                book.setBookname(bookName);
                book.setISBN(isbn);
                book.setAuthorName(authorName);
                session.save(book);
                tx.commit();
                session.close();
                outputArea.append("Inserted: " + bookName + ", " + isbn + ", " + authorName + "\n");
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Session session = SESSION_FACTORY.openSession();
                Transaction tx = session.beginTransaction();
                int isbn = Integer.parseInt(deleteField.getText());
                Books book = (Books) session.get(Books.class, isbn);
                if (book != null) {
                    session.delete(book);
                    outputArea.append("Deleted: ISBN " + isbn + "\n");
                } else {
                    outputArea.append("No book found with ISBN " + isbn + "\n");
                }
                tx.commit();
                session.close();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Session session = SESSION_FACTORY.openSession();
                Transaction tx = session.beginTransaction();
                String newBookName = updateField1.getText();
                int isbn = Integer.parseInt(updateField2.getText());
                Books book = (Books) session.get(Books.class, isbn);
                if (book != null) {
                    book.setBookname(newBookName);
                    session.update(book);
                    outputArea.append("Updated: ISBN " + isbn + " to " + newBookName + "\n");
                } else {
                    outputArea.append("No book found with ISBN " + isbn + "\n");
                }
                tx.commit();
                session.close();
            }
        });

        btnView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Session session = SESSION_FACTORY.openSession();
                java.util.List<Books> books = session.createQuery("from Books", Books.class).getResultList();
                outputArea.setText("");
                for (Books book : books) {
                    outputArea.append("Book Name: " + book.getBookname() + ", ISBN: " + book.getISBN() + ", Author: " + book.getAuthorName() + "\n");
                }
                session.close();
            }
        });
    }

    // Helper methods for consistent styling
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(72, 61, 139));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setForeground(new Color(60, 60, 60));
        return label;
    }

    private JLabel createStyledLabel(String text, int fontSize, Color color) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, fontSize));
        label.setForeground(color);
        return label;
    }

    private JPanel createSectionPanel(String title, String[] labels) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder(title));
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        for (int i = 0; i < labels.length; i++) {
            JLabel lbl = createStyledLabel(labels[i]);
            gbc.gridx = 0;
            gbc.gridy = i;
            panel.add(lbl, gbc);

            JTextField textField = new JTextField(20);
            gbc.gridx = 1;
            panel.add(textField, gbc);
        }

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AdminUI().setVisible(true);
            }
        });
    }
}