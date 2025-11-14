package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.example.domain.Curso;
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

    @Override
    public Matricula buscarPorCodigoCurso(String codigo) {
        EntityManagerFactory conn = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager manager = conn.createEntityManager();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT m FROM Matricula m ");
        sb.append("INNER JOIN Curso c on c = m.curso ");
        sb.append("WHERE c.codigo = :codigoCurso");

        manager.getTransaction().begin();
        TypedQuery<Matricula> querry = manager.createQuery(sb.toString(), Matricula.class);
        querry.setParameter("codigoCurso", codigo);
        Matricula matricula = querry.getSingleResult();
        manager.getTransaction().commit();

        manager.close();
        conn.close();

        return matricula;
    }

    @Override
    public Matricula buscarPorCurso(Curso curso) {
        EntityManagerFactory conn = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager manager = conn.createEntityManager();

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT m FROM Matricula m ");
        sb.append("INNER JOIN Curso c on c = m.curso ");
        sb.append("WHERE c = :curso");

        manager.getTransaction().begin();
        TypedQuery<Matricula> querry = manager.createQuery(sb.toString(), Matricula.class);
        querry.setParameter("curso", curso);
        Matricula matricula = querry.getSingleResult();
        manager.getTransaction().commit();

        manager.close();
        conn.close();

        return matricula;
    }

    @Override
    public Matricula buscarPorCodigoCursoCriteria(String codigo) {
        EntityManagerFactory conn = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager manager = conn.createEntityManager();

        manager.getTransaction().begin();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Matricula> querry = builder.createQuery(Matricula.class);
        Root<Matricula> root = querry.from(Matricula.class);
        Join<Object, Object> join = root.join("curso", JoinType.INNER);
        querry.select(root).where(builder.equal(join.get("codigo"), codigo));

        TypedQuery<Matricula> typedQuery = manager.createQuery(querry);
        Matricula matricula = typedQuery.getSingleResult();
        manager.getTransaction().commit();

        manager.close();
        conn.close();

        return matricula;
    }
}
