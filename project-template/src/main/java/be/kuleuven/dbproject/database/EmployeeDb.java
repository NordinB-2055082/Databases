package be.kuleuven.dbproject.database;

import be.kuleuven.dbproject.EntityManagerProvider;
import be.kuleuven.dbproject.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class EmployeeDb {
    private final EntityManager entityManager;

    public EmployeeDb() {
        this.entityManager = EntityManagerProvider.getEntityManager();
    }

    public List<Employee> findEmployeeByName(String name) { //kunnen meerdere met dezelfde voornaam zijn
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Employee.class); // SELECT .... FROM Employee
        var root = query.from(Employee.class); // SELECT *
        query.where(criteriaBuilder.equal(root.get("name"), name));

        try {
            return entityManager.createQuery(query).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Employee> findEmployeeByLastName(String lastname) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Employee.class);
        var root = query.from(Employee.class);

        query.where(criteriaBuilder.equal(root.get("lastname"), lastname));

        try {
            return entityManager.createQuery(query).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Employee findEmployeeByEmail(String email) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Employee.class); // SELECT .... FROM Employee
        var root = query.from(Employee.class); // SELECT *

        query.where(criteriaBuilder.equal(root.get("email"), email));

        try {
            return entityManager.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Employee> findAllEmployees() {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Employee.class);
        var root = query.from(Employee.class);

        try {
            return entityManager.createQuery(query).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void createEmployee(Employee employee) {
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
    }

    public void updateEmployee(Employee employee) {
        entityManager.getTransaction().begin();
        entityManager.merge(employee);
        entityManager.getTransaction().commit();
    }

    public void deleteEmployee(Employee employee) {
        entityManager.getTransaction().begin();
        entityManager.remove(employee);
        entityManager.getTransaction().commit();
    }
}
