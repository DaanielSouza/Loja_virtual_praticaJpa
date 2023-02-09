package br.com.loja.util;

import br.com.loja.dao.CategoriaDao;
import br.com.loja.dao.ClienteDao;
import br.com.loja.dao.ProdutoDao;
import br.com.loja.entity.CategoriaEntity;
import br.com.loja.entity.ClientesEntity;
import br.com.loja.entity.ProdutoEntity;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class MockUtil {
    public static void popularBanco(){
        CategoriaEntity categoria = new CategoriaEntity("CELULARES");
        ClientesEntity cliente = new ClientesEntity("Daniel","123456");
        ProdutoEntity celular = new ProdutoEntity("Redmi 8 pro","Potente", BigDecimal.valueOf(1200.50), categoria);
        ProdutoEntity celular2 = new ProdutoEntity("Redmi 9 pro","Potente", BigDecimal.valueOf(12200.50), categoria);
        ProdutoEntity celular3 = new ProdutoEntity("Redmi 10 pro","Potente", BigDecimal.valueOf(12100.50), categoria);
        ProdutoEntity celular4 = new ProdutoEntity("Redmi 11 pro","Potente", BigDecimal.valueOf(12400.50), categoria);
        ProdutoEntity celular5 = new ProdutoEntity("Redmi 12 pro","Potente", BigDecimal.valueOf(12500.50), categoria);

        EntityManager em = JPAUtil.getEntityManager();
        CategoriaDao catDao = new CategoriaDao(em);
        ProdutoDao dao = new ProdutoDao(em);
        ClienteDao clienteDao = new ClienteDao(em);

        em.getTransaction().begin();
        catDao.cadastrar(categoria);
        dao.cadastrar(celular);
        dao.cadastrar(celular2);
        dao.cadastrar(celular3);
        dao.cadastrar(celular4);
        dao.cadastrar(celular5);
        clienteDao.cadastrar(cliente);
        em.getTransaction().commit();
        em.close();
    }
}
