package com.cse.Library_Management_System;



import javax.swing.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.SqlDateModel;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class IssueReturnBooksUI extends JFrame {
    private JTextField bookIdField, userIdField, returnDateField;
    private JButton issueButton, returnButton;
    private JDatePickerImpl returnDatePicker;
    private JPanel mainPanel;
    private Students students;

    public IssueReturnBooksUI(Students st) {
    	students = st;
        // Set up the frame
        setTitle("Issue/Return Books");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create main panel
        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JLabel lblTitle = new JLabel("Issue/Return Books", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setForeground(new Color(72, 61, 139)); // Title color
        mainPanel.add(lblTitle, gbc);

        // Book ID
        gbc.gridy++;
        gbc.gridwidth = 1;
        JLabel bookIdLabel = createStyledLabel("ISBN:");
        mainPanel.add(bookIdLabel, gbc);

        gbc.gridx = 1;
        bookIdField = new JTextField();
        bookIdField.setPreferredSize(new Dimension(200, 30));
        mainPanel.add(bookIdField, gbc);
        
     // Return Date
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel returnDateLabel = createStyledLabel("Return Date:");
        mainPanel.add(returnDateLabel, gbc);

        gbc.gridx = 1;
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        returnDatePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        mainPanel.add(returnDatePicker, gbc);

        gbc.gridx = 1;
        userIdField = new JTextField();
        userIdField.setPreferredSize(new Dimension(200, 30));
        mainPanel.add(userIdField, gbc);

        gbc.gridx = 1;
        returnDateField = new JTextField();
        returnDateField.setPreferredSize(new Dimension(200, 30));
        returnDateField.setEditable(false);  // Disable manual editing of return date
        mainPanel.add(returnDateField, gbc);

        // Issue and Return buttons
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        issueButton = createStyledButton("Issue Book");
        mainPanel.add(issueButton, gbc);

        gbc.gridx = 1;
        returnButton = createStyledButton("Return Book");
        mainPanel.add(returnButton, gbc);

        // Add the panel to the frame
        add(mainPanel);

        // Button listeners
        issueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String bookid = bookIdField.getText();
            	
            	Session se = new Configuration().configure().addAnnotatedClass(Books.class).buildSessionFactory().openSession();
            	Books books = (Books) se.get(Books.class, Integer.parseInt(bookid));
            	
            	if(books != null) {
	            	Date selectedDate = (Date) returnDatePicker.getModel().getValue();
	                if (selectedDate != null) {
	                    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
	                    String formattedDate = dateFormatter.format(selectedDate);
	                    String currentDate = dateFormatter.format(new Date());
	                    
	                    
	                    Configuration con = new Configuration().configure().addAnnotatedClass(IssueBook.class);
	                    SessionFactory sf = con.buildSessionFactory();
	                    Session s = sf.openSession();
	                    Transaction tx = s.beginTransaction();
	                    
	                    IssueBook book = new IssueBook();
	                    book.setBookid(bookid);
	                    book.setUsername(students.getStudentEmail());
	                    book.setIssueDate(currentDate);
	                    book.setReturnDate(formattedDate);
	                    
	                    s.save(book);
	                    tx.commit();
	                    
	                    JOptionPane.showMessageDialog(IssueReturnBooksUI.this, "Your book successfully issued.");
	                    
	                } else {
	                	JOptionPane.showMessageDialog(null, "Please select date.", "Error", JOptionPane.ERROR_MESSAGE);
	                }
            	} else {
                	JOptionPane.showMessageDialog(null, "Please enter valid book id", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	String bookid = bookIdField.getText();
            	
            	Configuration con = new Configuration().configure().addAnnotatedClass(IssueBook.class);
                SessionFactory sf = con.buildSessionFactory();
                Session s = sf.openSession();
                Transaction tx = s.beginTransaction();
                
                IssueBook books = (IssueBook) s.get(IssueBook.class, students.getStudentEmail());
            	
            	if(books != null && books.getBookid().equals(bookid)) {
	            	s.delete(books);
	            	JOptionPane.showMessageDialog(IssueReturnBooksUI.this, "Your have returned: " + bookid);
            	} else {
                	JOptionPane.showMessageDialog(null, "You have not issued: " + bookid, "Error", JOptionPane.ERROR_MESSAGE);
                }
            	
            	tx.commit();
            }
        });
    }

    // Method to style buttons
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

    // Method to create styled labels
    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setForeground(new Color(60, 60, 60)); // Dark grey text
        return label;
    }
    
    private class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {
        private String datePattern = "dd/MM/yyyy";
        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);
        }

        @Override
        public String valueToString(Object value) throws ParseException {
            if (value != null) {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }
            return "";
        }
    }

    public static void main(String[] args) {
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Students.class);
        SessionFactory sf = con.buildSessionFactory();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        
        Students st = (Students) s.get(Students.class, "prashik@gmail.com");
        
        tx.commit();
    	
        SwingUtilities.invokeLater(() -> {
            new IssueReturnBooksUI(st).setVisible(true);
        });
    }
}