package org.example.dao;

import org.example.config.HibernateConfig;
import org.example.hibernate_entities.Client;
import org.example.hibernate_entities.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PlanetDao {
    private SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    // Create
    public void save(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(planet);
            tx.commit();
        }
    }

    // Read
    public Planet findById(String id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Planet.class, id);
        }
    }

    // Update
    public void update(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(planet);
            tx.commit();
        }
    }

    // Delete
    public void delete(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(planet);
            tx.commit();
        }
    }
}
