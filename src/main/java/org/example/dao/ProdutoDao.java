package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.domain.Produto;

public class ProdutoDao implements IProdutoDao{

    @Override
    public Produto cadastrar(Produto produto) {
        EntityManagerFactory conn =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = conn.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        entityManager.close();
        conn.close();

        return produto;
    }
}
