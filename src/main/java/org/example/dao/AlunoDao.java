package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.domain.Aluno;

public class AlunoDao implements IAlunoDao{
    @Override
    public Aluno cadastrar(Aluno aluno) {
        EntityManagerFactory conn = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager manager = conn.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(aluno);
        manager.getTransaction().commit();

        return aluno;
    }
}
