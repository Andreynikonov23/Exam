package ru.sapteh.services;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.sapteh.dao.DAO;
import ru.sapteh.models.Client;

import java.util.List;

public class ClientServ implements DAO<Client, Integer> {
    private SessionFactory factory;
    public ClientServ (SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Client client) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Client client) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(client);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Client client) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(client);
            session.getTransaction().commit();
        }
    }

    @Override
    public Client read(Integer id) {
        try (Session session = factory.openSession()) {
            Client result = session.get(Client.class, id);
            if (result != null) {
                Hibernate.initialize(result.getClientservices());
                Hibernate.initialize(result.getTagofclients());
                Hibernate.initialize(result.getGenders());
            }
            return result;
        }
    }

    @Override
    public List<Client> findByAll() {
        return null;
    }
}
