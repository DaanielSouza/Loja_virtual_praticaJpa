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
        ProdutoEntity celular = new ProdutoEntity("Redmi 8 pro","Potente", BigDecimal.valueOf(1200.50), categoria);
        ClientesEntity cliente = new ClientesEntity("Daniel","123456");

        EntityManager em = JPAUtil.getEntityManager();
        CategoriaDao catDao = new CategoriaDao(em);
        ProdutoDao dao = new ProdutoDao(em);
        ClienteDao clienteDao = new ClienteDao(em);

        em.getTransaction().begin();
        catDao.cadastrar(categoria);
        dao.cadastrar(celular);
        clienteDao.cadastrar(cliente);
        em.getTransaction().commit();
        em.close();
    }
}
