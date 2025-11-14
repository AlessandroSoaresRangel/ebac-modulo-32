package org.exemple;

import org.example.dao.*;
import org.example.domain.Aluno;
import org.example.domain.Computador;
import org.example.domain.Curso;
import org.example.domain.Matricula;
import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;

public class MatriculaTest {

    IMatriculaDao dao;
    ICursoDao cursoDao;
    IAlunoDao alunoDao;
    IComputadorDao computadorDao;

     public MatriculaTest () {
         dao = new MatriculaDao();
         cursoDao = new CursoDao();
         alunoDao = new AlunoDao();
         computadorDao = new ComputadorDao();

     }

    @Test
    public void cadastrar() {
         Curso curso = criarCurso("A25645");
         Aluno aluno = criarAluno("A5");


        Matricula matricula = new Matricula();
        matricula.setCodigo("A1");
        matricula.setDataMatricula(Instant.now());
        matricula.setStatus("ATIVA");
        matricula.setValor(2000D);
        matricula.setCurso(curso);
        matricula.setAluno(aluno);
        aluno.setMatricula(matricula);
        matricula = dao.cadastrar(matricula);

        assert matricula != null;

        Matricula matricula1 = this.dao.buscarPorCodigoCurso(matricula.getCurso().getCodigo());

        assert matricula1 != null;
        Assert.assertEquals(matricula.getId(), matricula1.getId());

        Matricula matricula2 = this.dao.buscarPorCurso(matricula.getCurso());

        assert matricula2 != null;
        Assert.assertEquals(matricula2.getId(), matricula.getId());

    }

    private Curso criarCurso(String codigo) {
        Curso curso = new Curso();
        curso.setNome("teste nome");
        curso.setDescricao("teste");
        curso.setCodigo(codigo);
        return cursoDao.cadastrar(curso);

    }

    private Aluno criarAluno(String codigo) {
        Computador computador = criarComputador("A30");
         Aluno aluno = new Aluno();
         aluno.setCodigo(codigo);
         aluno.setNome("Aluno teste");
         aluno.add(computador);

         return alunoDao.cadastrar(aluno);
    }

    public Computador criarComputador(String codigo) {
         Computador computador = new Computador();
         computador.setCodigo(codigo);
         computador.setDescricao("descriçao teste");
         return computadorDao.cadastrar(computador);
    }
}
