package br.com.loja.dao;

import br.com.loja.entity.ProdutoEntity;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
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

    public List<ProdutoEntity> buscarPorNome(String nome){
        String jpql = "SELECT p FROM ProdutoEntity as p WHERE p.nome = :nome";
        return this.em.createQuery(jpql,ProdutoEntity.class).setParameter("nome",nome).getResultList();
    }
    public BigDecimal buscarPrecoPorNomeDaCategoria(String nome){
        String jpql = "SELECT p.preco FROM ProdutoEntity as p WHERE p.categoria.nome = :nome";
        return this.em.createQuery(jpql, BigDecimal.class).setParameter("nome",nome).getSingleResult();
    }
}
