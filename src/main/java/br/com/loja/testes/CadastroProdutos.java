package br.com.loja.testes;

import br.com.loja.dao.CategoriaDao;
import br.com.loja.dao.ProdutoDao;
import br.com.loja.entity.CategoriaEntity;
import br.com.loja.entity.ProdutoEntity;
import br.com.loja.util.JPAUtil;
import br.com.loja.util.MockUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroProdutos {

    public static void main(String[] args) {
        MockUtil.popularBanco();
        Long id = 2L;

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao dao = new ProdutoDao(em);

        ProdutoEntity produto = dao.buscarPorId(id);
        System.out.println(produto.getPreco());

        List<ProdutoEntity> todos = dao.buscarTodos();
        todos.forEach(e -> System.out.println(e.getNome()));

        System.out.println(dao.buscarPrecoPorNomeDaCategoria("CELULARES"));
    }
}
