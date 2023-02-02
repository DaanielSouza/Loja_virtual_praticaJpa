package br.com.loja.testes;

import br.com.loja.dao.CategoriaDao;
import br.com.loja.dao.ProdutoDao;
import br.com.loja.entity.CategoriaEntity;
import br.com.loja.entity.ProdutoEntity;
import br.com.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroProdutos {

    public static void main(String[] args) {
        cadastrarProduto();
        Long id = 2L;

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao dao = new ProdutoDao(em);

        ProdutoEntity produto = dao.buscarPorId(id);
        System.out.println(produto.getPreco());

        List<ProdutoEntity> todos = dao.buscarTodos();
        todos.forEach(e -> System.out.println(e.getNome()));
    }

    public static void cadastrarProduto(){
        CategoriaEntity categoria = new CategoriaEntity("CELULARES");
        ProdutoEntity celular = new ProdutoEntity("Redmi 8 pro","Potente",BigDecimal.valueOf(1200.50), categoria);
        ProdutoEntity celular2 = new ProdutoEntity("Redmi 9 pro","Potente2",BigDecimal.valueOf(12020.50), categoria);
        ProdutoEntity celular3 = new ProdutoEntity("Redmi 10 pro","Potente3",BigDecimal.valueOf(12003.50), categoria);
        ProdutoEntity celular4 = new ProdutoEntity("Redmi 11 pro","Potente4",BigDecimal.valueOf(12004.50), categoria);
        ProdutoEntity celular5 = new ProdutoEntity("Redmi 12 pro","Potente5",BigDecimal.valueOf(12005.50), categoria);

        EntityManager em = JPAUtil.getEntityManager();
        CategoriaDao catDao = new CategoriaDao(em);
        ProdutoDao dao = new ProdutoDao(em);

        em.getTransaction().begin();
        catDao.cadastrar(categoria);
        dao.cadastrar(celular);
        dao.cadastrar(celular2);
        dao.cadastrar(celular3);
        dao.cadastrar(celular4);
        dao.cadastrar(celular5);
        em.getTransaction().commit();

        em.close();
    }
}
