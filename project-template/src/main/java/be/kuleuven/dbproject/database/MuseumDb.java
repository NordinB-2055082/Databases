package be.kuleuven.dbproject.database;
import be.kuleuven.dbproject.EntityManagerProvider;
import be.kuleuven.dbproject.model.Game;
import be.kuleuven.dbproject.model.Museum;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class MuseumDb {
    private final EntityManager entityManager;

    public MuseumDb() {
        this.entityManager = EntityManagerProvider.getEntityManager();
    }

    public Museum findMuseumById(Long id) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Museum.class);
        var root = query.from(Museum.class);

        query.where(criteriaBuilder.equal(root.get("museumId"), id));

        try {
            return entityManager.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Museum findMuseumByLocation(String museumLocation) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Museum.class);
        var root = query.from(Museum.class);

        query.where(criteriaBuilder.equal(root.get("location"), museumLocation));

        try {
            return entityManager.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

    public void createMuseum(Museum museum) {
        entityManager.getTransaction().begin();
        entityManager.persist(museum);
        entityManager.getTransaction().commit();
    }

    public void updateMuseum(Museum museum) {
        entityManager.getTransaction().begin();
        entityManager.merge(museum);
        entityManager.getTransaction().commit();
    }

    public void deleteMuseum(Museum museum) {
        entityManager.getTransaction().begin();
        entityManager.remove(museum);
        entityManager.getTransaction().commit();
    }

    public List<Museum> findAllMuseums() {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Museum.class);
        var root = query.from(Museum.class);

        try {
            return entityManager.createQuery(query).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}