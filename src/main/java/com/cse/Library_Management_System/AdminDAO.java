package com.cse.Library_Management_System;


import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdminDAO {

    public void saveAdmin(Admin admin) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(admin);  // Saving the Admin object to the database
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Admin getAdmin(String username) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Admin.class, username);  // Retrieve the Admin object using the username
        }
    }
}
