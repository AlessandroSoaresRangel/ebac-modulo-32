package org.exemple;

import org.example.dao.CursoDao;
import org.example.dao.ICursoDao;
import org.example.domain.Curso;
import org.junit.Assert;
import org.junit.Test;

public class CursoTest {

    private ICursoDao dao;

    public CursoTest () {
        dao = new CursoDao();
    }

    @Test
    public void cadastrar() {
        Curso curso = new Curso();
        curso.setCodigo("A1");
        curso.setDescricao("CURSO TESTE");
        curso.setNome("Curso de java backend");
        curso = dao.cadastrar(curso);

        assert curso != null;
        Assert.assertNotNull(curso.getId());
    }
}
