package org.example.dao;

import org.example.config.HibernateConfig;
import org.example.hibernate_entities.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TicketDao {
    private SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    // Create
    public void save(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(ticket);
            tx.commit();
        }
    }

    // Read
    public Ticket findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Ticket.class, id);
        }
    }

    // Update
    public void update(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(ticket);
            tx.commit();
        }
    }

    // Delete
    public void delete(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(ticket);
            tx.commit();
        }
    }
}
