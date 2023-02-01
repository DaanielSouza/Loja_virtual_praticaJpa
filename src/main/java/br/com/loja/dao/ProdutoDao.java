package br.com.loja.dao;

import br.com.loja.entity.ProdutoEntity;

import javax.persistence.EntityManager;

public class ProdutoDao {
    private EntityManager em;

    public ProdutoDao(EntityManager em){
        this.em = em;
    }

    public void cadastrar(ProdutoEntity produtoEntity){
        this.em.getTransaction().begin();
        this.em.persist(produtoEntity);
        this.em.getTransaction().commit();
    }
}
