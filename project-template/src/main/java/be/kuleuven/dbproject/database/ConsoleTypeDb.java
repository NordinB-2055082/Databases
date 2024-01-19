package be.kuleuven.dbproject.database;

import be.kuleuven.dbproject.EntityManagerProvider;
import be.kuleuven.dbproject.model.ConsoleType;
import be.kuleuven.dbproject.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class ConsoleTypeDb {
    private final EntityManager entityManager;

    public ConsoleTypeDb() {
        this.entityManager = EntityManagerProvider.getEntityManager();
    }

    public List<ConsoleType> findConsoleTypeByName(String name) { //kunnen meerdere met dezelfde voornaam zijn
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(ConsoleType.class); // SELECT .... FROM Employee
        var root = query.from(ConsoleType.class); // SELECT *
        query.where(criteriaBuilder.equal(root.get("name"), name));

        try {
            return entityManager.createQuery(query).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<ConsoleType> getAllConsoleTypes() {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(ConsoleType.class);
        var root = query.from(ConsoleType.class);

        try {
            return entityManager.createQuery(query).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void createConsoleType(ConsoleType consoleType) {
        entityManager.getTransaction().begin();
        entityManager.persist(consoleType);
        entityManager.getTransaction().commit();
    }

    public void updateConsoleType(ConsoleType consoleType) {
        entityManager.getTransaction().begin();
        entityManager.merge(consoleType);
        entityManager.getTransaction().commit();
    }

    public void deleteConsoleType(ConsoleType consoleType) {
        entityManager.getTransaction().begin();
        entityManager.remove(consoleType);
        entityManager.getTransaction().commit();
    }
}
