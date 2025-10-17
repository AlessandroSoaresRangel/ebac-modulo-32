package org.exemple;

import org.example.dao.IMatriculaDao;
import org.example.dao.MatriculaDao;
import org.example.domain.Matricula;
import org.junit.Test;

import java.time.Instant;

public class MatriculaTest {

    IMatriculaDao dao;

     public MatriculaTest () {
         dao = new MatriculaDao();
     }

    @Test
    public void cadastrar() {
        Matricula matricula = new Matricula();
        matricula.setCodigo("A1");
        matricula.setDataMatricula(Instant.now());
        matricula.setStatus("ATIVA");
        matricula.setValor(2000D);

        matricula = dao.cadastrar(matricula);

        assert matricula != null;
    }
}
