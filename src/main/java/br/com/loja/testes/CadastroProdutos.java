package br.com.loja.testes;

import br.com.loja.dao.CategoriaDao;
import br.com.loja.dao.ProdutoDao;
import br.com.loja.entity.CategoriaEntity;
import br.com.loja.entity.ProdutoEntity;
import br.com.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroProdutos {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();

        CategoriaEntity categoria = new CategoriaEntity("CELULARES");
        CategoriaDao catDao = new CategoriaDao(em);
        catDao.cadastrar(categoria);
        ProdutoEntity celular = new ProdutoEntity("Redmi 8 pro","Potente",BigDecimal.valueOf(1200.50), categoria);

        ProdutoDao dao = new ProdutoDao(em);
        dao.cadastrar(celular);
        em.close();
    }
}
