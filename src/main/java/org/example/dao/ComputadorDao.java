package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.domain.Computador;

public class ComputadorDao implements IComputadorDao{
    @Override
    public Computador cadastrar(Computador computador) {
        EntityManagerFactory conn = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager manager = conn.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(computador);
        manager.getTransaction().commit();

        manager.close();

        conn.close();

        return computador;
    }
}
