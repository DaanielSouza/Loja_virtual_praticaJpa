package br.com.loja.dao;

import br.com.loja.entity.CategoriaEntity;
import br.com.loja.entity.ProdutoEntity;

import javax.persistence.EntityManager;

public class CategoriaDao {
    private EntityManager em;

    public CategoriaDao(EntityManager em){
        this.em = em;
    }

    public void cadastrar(CategoriaEntity categoriaEntity){
        this.em.getTransaction().begin();
        this.em.persist(categoriaEntity);
        this.em.getTransaction().commit();
    }
}
