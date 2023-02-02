package br.com.loja.dao;

import br.com.loja.entity.ProdutoEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDao {
    private EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(ProdutoEntity produtoEntity) {
        this.em.persist(produtoEntity);
    }

    public ProdutoEntity buscarPorId(Long id) {
        return em.find(ProdutoEntity.class, id);
    }

    public List<ProdutoEntity> buscarTodos() {
        String jpql = "SELECT p FROM ProdutoEntity as p";
        return this.em.createQuery(jpql, ProdutoEntity.class).getResultList();
    }
}
