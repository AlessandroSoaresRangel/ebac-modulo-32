package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.domain.Matricula;

public class MatriculaDao implements IMatriculaDao{


    @Override
    public Matricula cadastrar(Matricula matricula) {
        EntityManagerFactory conn =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = conn.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(matricula);
        entityManager.getTransaction().commit();

        entityManager.close();
        conn.close();

        return matricula;
    }
}
