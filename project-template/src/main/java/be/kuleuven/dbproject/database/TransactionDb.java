package be.kuleuven.dbproject.database;

import be.kuleuven.dbproject.EntityManagerProvider;

import be.kuleuven.dbproject.model.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;

public class TransactionDb {
    private final EntityManager entityManager;

    public TransactionDb() {
        this.entityManager = EntityManagerProvider.getEntityManager();
    }

    public Transaction findTranasctionById(Long id) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Transaction.class);
        var root = query.from(Transaction.class);

        query.where(criteriaBuilder.equal(root.get("transactionId"), id));

        try {
            return entityManager.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }


    public void createTransaction(Transaction transaction) {
        entityManager.getTransaction().begin();
        entityManager.persist(transaction);
        try{
            entityManager.getTransaction().commit();
        }
        catch(RollbackException e){
            e.printStackTrace();
            Throwable cause = e.getCause();
            while (cause != null) {
                System.err.println("Cause R: " + cause);
                cause = cause.getCause();
            }
        }


    }

    public void updateMuseum(Transaction transaction) {
        entityManager.getTransaction().begin();
        entityManager.merge(transaction);
        entityManager.getTransaction().commit();
    }

    public void deleteMuseum(Transaction transaction) {
        entityManager.getTransaction().begin();
        entityManager.remove(transaction);
        entityManager.getTransaction().commit();
    }
}
