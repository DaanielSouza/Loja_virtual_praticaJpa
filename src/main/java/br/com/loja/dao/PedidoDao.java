package br.com.loja.dao;

import br.com.loja.entity.PedidosEntity;
import br.com.loja.model.RelatorioModel;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDao {
    private EntityManager em;

    public PedidoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(PedidosEntity pedidosEntity) {
        this.em.persist(pedidosEntity);
    }

    public BigDecimal valorTotalVendido(){
        String jpql = "SELECT SUM(p.valorTotal) FROM PedidosEntity p ";

        return em.createQuery(jpql, BigDecimal.class)
                .getSingleResult();
    }

    public List<PedidosEntity> retornaPedidos(){
        String jpql = "SELECT p FROM PedidosEntity p ";

        return em.createQuery(jpql, PedidosEntity.class)
                .getResultList();
    }

    public List<RelatorioModel> relatorioVendas(){
        String jpql = "SELECT new br.com.loja.model.RelatorioModel(produto.nome, " +
                "SUM(item.quantidade), " +
                "MAX(pedido.data)) " +
                "FROM PedidosEntity pedido " +
                "JOIN pedido.itens item " +
                "JOIN item.produto produto " +
                "GROUP BY produto.nome " +
                "ORDER BY item.quantidade DESC";
        return em.createQuery(jpql, RelatorioModel.class)
                .getResultList();
    }
}
