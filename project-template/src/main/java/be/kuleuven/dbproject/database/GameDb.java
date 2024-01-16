package be.kuleuven.dbproject.database;

import be.kuleuven.dbproject.EntityManagerProvider;
import be.kuleuven.dbproject.model.ConsoleType;

import be.kuleuven.dbproject.model.Game;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class GameDb {
    private final EntityManager entityManager;

    public GameDb() {
        this.entityManager = EntityManagerProvider.getEntityManager();
    }

    public List<Game> findGameByTitle(String title) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Game.class); // SELECT .... FROM Employee
        var root = query.from(Game.class); // SELECT *
        query.where(criteriaBuilder.equal(root.get("title"), title));

        try {
            return entityManager.createQuery(query).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Long getHighestID() {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Long.class);
        var root = query.from(Game.class);

        query.select(criteriaBuilder.max(root.get("gameId")));

        try {
            return entityManager.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }


    public List<Game> findAllGames() {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Game.class);
        var root = query.from(Game.class);

        try {
            return entityManager.createQuery(query).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void createGame(Game game) {
        entityManager.getTransaction().begin();
        entityManager.persist(game);
        entityManager.getTransaction().commit();
    }


    public void updateGame(Game game) {
        entityManager.getTransaction().begin();
        entityManager.merge(game);
        entityManager.getTransaction().commit();
    }

    public void deleteGame(Game game) {
        entityManager.getTransaction().begin();
        entityManager.remove(game);
        entityManager.getTransaction().commit();
    }

}
