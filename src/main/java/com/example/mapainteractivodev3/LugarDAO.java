package com.example.mapainteractivodev3;

import com.example.mapainteractivodev3.Lugar;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class LugarDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");

    public void crearLugar(Lugar lugar) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(lugar);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
