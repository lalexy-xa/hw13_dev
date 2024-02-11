package org.example.config;

import lombok.Getter;
import org.example.hibernate_entities.Client;
import org.example.hibernate_entities.Planet;
import org.example.hibernate_entities.Ticket;
import org.example.util.ConfigurationUtils;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateConfig {
    private static volatile HibernateConfig INSTANCE;

    @Getter
    private SessionFactory sessionFactory;

    private HibernateConfig() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }

    public static HibernateConfig getInstance() {
        if (INSTANCE == null){
            synchronized (HibernateConfig.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HibernateConfig();
                }
            }
        }
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();
    }
}

