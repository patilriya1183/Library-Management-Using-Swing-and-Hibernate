//package com.cse.Library_Management_System;
//
//
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.List;
//
//public class BookHistoryUI extends JFrame {
//
//    private JPanel mainPanel;
//
//    public BookHistoryUI(List<BookHistory> historyList) {
//        // Set up the frame
//        setTitle("Library Management System - Book History");
//        setSize(600, 400);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        // Create the main panel
//        mainPanel = createBookHistoryPanel(historyList);
//      
//        // Add the main panel to the frame
//        add(mainPanel);
//    }
//
//    // Method to style JTable
//    private JTable createStyledTable(DefaultTableModel model) {
//        JTable table = new JTable(model);
//        table.setFont(new Font("Arial", Font.PLAIN, 14));
//        table.setRowHeight(30); // Increase row height for better visibility
//        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
//        table.getTableHeader().setBackground(new Color(72, 61, 139)); // Dark blue background for header
//        table.getTableHeader().setForeground(Color.WHITE); // White text for header
//        return table;
//    }
//
//    // Book History Panel
//    private JPanel createBookHistoryPanel(List<BookHistory> historyList) {
//        JPanel historyPanel = new JPanel();
//        historyPanel.setLayout(new BorderLayout());
//        historyPanel.setBackground(Color.WHITE);
//
//        // Set up the table data
//        String[] columnNames = {"Book Name", "Book ID", "Issue Date", "Return Date"};
//        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
//
//        for (BookHistory history : historyList) {
//            model.addRow(new Object[]{history.getBookName(), history.getBookId(), history.getIssueDate(), history.getReturnDate()});
//        }
//
//        // Create the table and style it
//        JTable table = createStyledTable(model);
//        JScrollPane scrollPane = new JScrollPane(table);
//        historyPanel.add(scrollPane, BorderLayout.CENTER);
//
//        // Add a title label at the top
//        JLabel lblTitle = new JLabel("Book History", SwingConstants.CENTER);
//        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
//        lblTitle.setForeground(new Color(72, 61, 139)); // Dark blue color for the title
//        lblTitle.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Padding
//        historyPanel.add(lblTitle, BorderLayout.NORTH);
//
//        JButton btnLogout = new JButton("Logout");
//    	mainPanel.add(btnLogout);
//        add(mainPanel);
//        btnLogout.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//        		JOptionPane.showMessageDialog(null, "You Are Logout Now", "Sucess", JOptionPane.ERROR_MESSAGE);
//                dispose(); // close the current window
////                new HomeUI().setVisible(true); // open the home interface
//            }
//        });
//        
//	
//        
//        return historyPanel;
//    }
//    
//
//    public static void main(String[] args) {
//        // Sample data
//        List<BookHistory> historyList = List.of(
//                new BookHistory("OS", "111111", "2023-01-01", "2023-01-10"),
//                new BookHistory("DBMS", "111112", "2023-02-01", "2023-02-10")
//        );
//     
//        SwingUtilities.invokeLater(() -> {
//            BookHistoryUI ui = new BookHistoryUI(historyList);
//            ui.setVisible(true);
//        });
//    }
//    
//}
//
//// BookHistory class as before
//class BookHistory {
//    private String bookName;
//    private String bookId;
//    private String issueDate;
//    private String returnDate;
//
//    public BookHistory(String bookName, String bookId, String issueDate, String returnDate) {
//        this.bookName = bookName;
//        this.bookId = bookId;
//        this.issueDate = issueDate;
//        this.returnDate = returnDate;
//    }
//
//    public String getBookName() {
//        return bookName;
//    }
//
//    public String getBookId() {
//        return bookId;
//    }
//
//    public String getIssueDate() {
//        return issueDate;
//    }
//
//    public String getReturnDate() {
//        return returnDate;
//    }
//}



package com.cse.Library_Management_System;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BookHistoryUI extends JFrame {

    private JPanel mainPanel;

    public BookHistoryUI(List<BookHistory> historyList) {
        // Set up the frame
        setTitle("Library Management System - Book History");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the main panel
        mainPanel = createBookHistoryPanel(historyList);

        // Add the main panel to the frame
        add(mainPanel);
    }

    private JTable createStyledTable(DefaultTableModel model) {
        JTable table = new JTable(model);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(30);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(72, 61, 139));
        table.getTableHeader().setForeground(Color.WHITE);
        return table;
    }

    private JPanel createBookHistoryPanel(List<BookHistory> historyList) {
        JPanel historyPanel = new JPanel();
        historyPanel.setLayout(new BorderLayout());
        historyPanel.setBackground(Color.WHITE);

        // Set up the table data
        String[] columnNames = {"Book Name", "Book ID", "Issue Date", "Return Date"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (BookHistory history : historyList) {
            model.addRow(new Object[]{history.getBookName(), history.getBookId(), history.getIssueDate(), history.getReturnDate()});
        }

        JTable table = createStyledTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        historyPanel.add(scrollPane, BorderLayout.CENTER);

        JLabel lblTitle = new JLabel("Book History", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setForeground(new Color(72, 61, 139));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        historyPanel.add(lblTitle, BorderLayout.NORTH);

        JButton btnLogout = new JButton("Logout");
        mainPanel.add(btnLogout);
        add(mainPanel);
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "You Are Logout Now", "Success", JOptionPane.ERROR_MESSAGE);
                dispose(); // Close the window
            }
        });

        return historyPanel;
    }

    public static void main(String[] args) {
        // Fetch book history from the database using BooksDAO
        BooksDAO booksDAO = new BooksDAO();
        List<BookHistory> historyList = List.of(
                new BookHistory("OS", "111111", "2023-01-01", "2023-01-10"),
                new BookHistory("DBMS", "111112", "2023-02-01", "2023-02-10")
        );

        SwingUtilities.invokeLater(() -> {
            BookHistoryUI ui = new BookHistoryUI(historyList);
            ui.setVisible(true);
        });
    }
}
