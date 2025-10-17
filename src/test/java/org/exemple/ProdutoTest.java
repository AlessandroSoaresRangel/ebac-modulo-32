package org.exemple;

import org.example.dao.IProdutoDao;
import org.example.dao.ProdutoDao;
import org.example.domain.Produto;
import org.junit.Test;

public class ProdutoTest {

    IProdutoDao dao;

    public ProdutoTest () {
        dao = new ProdutoDao();
    }

    @Test
    public void cadastrar() {
        Produto produto = new Produto();
        produto.setNome("Teste");
        produto.setPreco(3204D);

        produto = dao.cadastrar(produto);

        assert produto != null;
    }
}
