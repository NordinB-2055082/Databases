package be.kuleuven.dbproject.database;
import be.kuleuven.dbproject.EntityManagerProvider;
import be.kuleuven.dbproject.model.Museum;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

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
}