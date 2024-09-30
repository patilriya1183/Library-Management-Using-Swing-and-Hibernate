//package com.cse.Library_Management_System;
//
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import org.hibernate.query.Query;
//import com.cse.Library_Management_System.*;
//
//public class IssueBookDAO {
//
//    
//
//	// Issue Book
//    public boolean issueBook(int bookId, int userId, String issueDate, String returnDate) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//
//            // Create IssuedBook entry
//            IssuedBook issuedBook = new IssuedBook();
//            issuedBook.setBookId(bookId);
//            issuedBook.setUserId(userId);
//            issuedBook.setIssueDate(issueDate);
//            issuedBook.setReturnDate(returnDate);
//            issuedBook.setStatus("Issued");
//
//            session.save(issuedBook);
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            if (transaction != null) transaction.rollback();
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    // Return Book
//    public boolean returnBook(int bookId, int userId) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//
//            // Update status to 'Returned'
//            String hql = "UPDATE IssuedBook SET status = :status WHERE bookId = :bookId AND userId = :userId AND status = 'Issued'";
//            Query query = session.createQuery(hql);
//            query.setParameter("status", "Returned");
//            query.setParameter("bookId", bookId);
//            query.setParameter("userId", userId);
//            
//            int result = query.executeUpdate();
//            transaction.commit();
//            
//            return result > 0;
//        } catch (Exception e) {
//            if (transaction != null) transaction.rollback();
//            e.printStackTrace();
//            return false;
//        }
//    }
//}



package com.cse.Library_Management_System;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class IssueBookDAO {

    // Issue a book to a user
    public boolean issueBook(int bookId, int userId, String issueDate, String returnDate) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Create IssuedBook entry
            IssuedBook issuedBook = new IssuedBook();
            issuedBook.setBookId(bookId);
            issuedBook.setUserId(userId);
            issuedBook.setIssueDate(issueDate);
            issuedBook.setReturnDate(returnDate);
            issuedBook.setStatus("Issued");

            session.save(issuedBook);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    // Return a book
    public boolean returnBook(int bookId, int userId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            // Update status to 'Returned'
            String hql = "UPDATE IssuedBook SET status = :status WHERE bookId = :bookId AND userId = :userId AND status = 'Issued'";
            Query query = session.createQuery(hql);
            query.setParameter("status", "Returned");
            query.setParameter("bookId", bookId);
            query.setParameter("userId", userId);

            int result = query.executeUpdate();
            transaction.commit();

            return result > 0;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
