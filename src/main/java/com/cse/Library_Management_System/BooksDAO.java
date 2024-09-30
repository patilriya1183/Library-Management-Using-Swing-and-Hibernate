package com.cse.Library_Management_System;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BooksDAO {

    public void saveBook(Books book) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(book);  // Save book to database
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Books> getAllBooks() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Books", Books.class).list();
        }
    }

    public Books getBookByISBN(int isbn) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Books.class, isbn);
        }
    }

    public void deleteBook(int isbn) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Books book = session.get(Books.class, isbn);
            if (book != null) {
                session.delete(book);  // Delete book from database
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
