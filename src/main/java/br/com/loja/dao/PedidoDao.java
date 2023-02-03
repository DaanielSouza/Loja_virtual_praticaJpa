package br.com.loja.dao;

import br.com.loja.entity.PedidosEntity;
import br.com.loja.entity.ProdutoEntity;

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
}
