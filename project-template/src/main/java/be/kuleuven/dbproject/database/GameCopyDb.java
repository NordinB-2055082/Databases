package be.kuleuven.dbproject.database;

import be.kuleuven.dbproject.EntityManagerProvider;
import be.kuleuven.dbproject.model.Game;
import be.kuleuven.dbproject.model.GameCopy;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class GameCopyDb {
    private final EntityManager entityManager;

    public GameCopyDb() {
        this.entityManager = EntityManagerProvider.getEntityManager();
    }

    public List<GameCopy> findGameCopyByTitle(String title) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(GameCopy.class); // SELECT .... FROM Employee
        var root = query.from(GameCopy.class); // SELECT *
        query.where(criteriaBuilder.equal(root.get("title"), title));

        try {
            return entityManager.createQuery(query).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }


    public List<GameCopy> findAllGameGameCopies() {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(GameCopy.class);
        var root = query.from(GameCopy.class);

        try {
            return entityManager.createQuery(query).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void createGameCopy(GameCopy gameCopy) {
        entityManager.getTransaction().begin();
        entityManager.persist(gameCopy);
        entityManager.getTransaction().commit();
    }


    public void updateGameCopy(GameCopy gameCopy) {
        entityManager.getTransaction().begin();
        entityManager.merge(gameCopy);
        entityManager.getTransaction().commit();
    }

    public void deleteGameCopy(GameCopy gameCopy) {
        entityManager.getTransaction().begin();
        entityManager.remove(gameCopy);
        entityManager.getTransaction().commit();
    }

}
