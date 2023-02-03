package br.com.loja.testes;

import br.com.loja.dao.ClienteDao;
import br.com.loja.dao.PedidoDao;
import br.com.loja.dao.ProdutoDao;
import br.com.loja.entity.ClientesEntity;
import br.com.loja.entity.ItemPedidoEntity;
import br.com.loja.entity.PedidosEntity;
import br.com.loja.entity.ProdutoEntity;
import br.com.loja.util.JPAUtil;
import br.com.loja.util.MockUtil;

import javax.persistence.EntityManager;

public class CadastroPedido {
    public static void main(String[] args) {
        MockUtil.popularBanco();

        EntityManager em = JPAUtil.getEntityManager();

        ProdutoDao produtoDao = new ProdutoDao(em);
        ClienteDao clienteDao = new ClienteDao(em);
        PedidoDao pedidoDao = new PedidoDao(em);

        ProdutoEntity produto = produtoDao.buscarPorId(2L);
        ClientesEntity cliente = clienteDao.buscarPorId(3L);
        PedidosEntity pedido = new PedidosEntity(cliente);
        pedido.addItem(new ItemPedidoEntity(10,produto,pedido));

        em.getTransaction().begin();

        clienteDao.cadastrar(cliente);
        pedidoDao.cadastrar(pedido);

        em.getTransaction().commit();
        em.close();
    }
}
