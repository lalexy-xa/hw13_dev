package org.example.dao;

import org.example.config.HibernateConfig;
import org.example.hibernate_entities.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ClientDao {
    private SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    // Create
    public void save(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(client);
            tx.commit();
        }
    }

    // Read
    public Client findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Client.class, id);
        }
    }

    // Update
    public void update(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(client);
            tx.commit();
        }
    }

    // Delete
    public void delete(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(client);
            tx.commit();
        }
    }
}
