package be.kuleuven.dbproject.database;

import be.kuleuven.dbproject.EntityManagerProvider;
import be.kuleuven.dbproject.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class ClientDb {
    private final EntityManager entityManager;

    public ClientDb() {
        this.entityManager = EntityManagerProvider.getEntityManager();
    }

    public List<Client> findClientByName(String name) { //kunnen meerdere met dezelfde voornaam zijn
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Client.class); // SELECT .... FROM Employee
        var root = query.from(Client.class); // SELECT *
        query.where(criteriaBuilder.equal(root.get("name"), name));

        try {
            return entityManager.createQuery(query).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Client> findClientByLastName(String lastname) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Client.class);
        var root = query.from(Client.class);

        query.where(criteriaBuilder.equal(root.get("lastname"), lastname));

        try {
            return entityManager.createQuery(query).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Client findClientByEmail(String email) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Client.class); // SELECT .... FROM Employee
        var root = query.from(Client.class); // SELECT *

        query.where(criteriaBuilder.equal(root.get("email"), email));

        try {
            return entityManager.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Client> findAllClients() {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Client.class);
        var root = query.from(Client.class);

        try {
            return entityManager.createQuery(query).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void createClient(Client client) {
        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();
    }

    public void updateClient(Client client) {
        entityManager.getTransaction().begin();
        entityManager.merge(client);
        entityManager.getTransaction().commit();
    }

    public void deleteClient(Client client) {
        entityManager.getTransaction().begin();
        entityManager.remove(client);
        entityManager.getTransaction().commit();
    }

}

