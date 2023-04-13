package br.com.loja.dao;

import br.com.loja.entity.ProdutoEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.time.LocalDate;
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

    public List<ProdutoEntity> buscarPorParametros(String nome, BigDecimal preco, LocalDate dataCadastro){
        String jpql = "SELECT p FROM ProdutoEntity p WHERE 1=1 ";
            if(nome != null && !nome.trim().isEmpty()){
                jpql += "AND p.nome = :nome ";
            }

            if(preco != null){
                jpql += "AND p.preco = :preco ";
            }

            if(dataCadastro != null) {
                jpql += "AND p.dataCadastro = :dataCadastro ";
            }
        TypedQuery<ProdutoEntity> query = em.createQuery(jpql, ProdutoEntity.class);
        if(nome != null && !nome.trim().isEmpty()){
            query.setParameter("nome", nome);
        }

        if(preco != null){
            query.setParameter("preco", preco);
        }

        if(dataCadastro != null) {
            query.setParameter("dataCadastro", dataCadastro);
        }
        return query.getResultList();
    }

    public List<ProdutoEntity> buscarPorParametrosCriteria(String nome, BigDecimal preco, LocalDate dataCadastro){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<ProdutoEntity> query = builder.createQuery(ProdutoEntity.class);
        Root<ProdutoEntity> from = query.from(ProdutoEntity.class);

        Predicate filtros = builder.and();

        if(nome != null && !nome.trim().isEmpty())
            filtros = builder.and(filtros, builder.equal(from.get("nome"), nome));

        if(preco != null) filtros = builder.and(filtros, builder.equal(from.get("preco"), preco));

        if(dataCadastro != null) filtros = builder.and(filtros, builder.equal(from.get("dataCadastro"), dataCadastro));
        query.where(filtros);

        return em.createQuery(query).getResultList();
    }
}
