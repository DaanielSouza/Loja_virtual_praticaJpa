package br.com.loja.testes;

import br.com.loja.dao.ClienteDao;
import br.com.loja.dao.PedidoDao;
import br.com.loja.dao.ProdutoDao;
import br.com.loja.model.RelatorioModel;
import br.com.loja.entity.ClientesEntity;
import br.com.loja.entity.ItemPedidoEntity;
import br.com.loja.entity.PedidosEntity;
import br.com.loja.entity.ProdutoEntity;
import br.com.loja.util.JPAUtil;
import br.com.loja.util.MockUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class CadastroPedido {
    public static void main(String[] args) {
        MockUtil.popularBanco();

        EntityManager em = JPAUtil.getEntityManager();

        ProdutoDao produtoDao = new ProdutoDao(em);
        ClienteDao clienteDao = new ClienteDao(em);
        PedidoDao pedidoDao = new PedidoDao(em);

        ProdutoEntity produto = produtoDao.buscarPorId(2L);
        ProdutoEntity produto2 = produtoDao.buscarPorId(3L);
        ProdutoEntity produto3 = produtoDao.buscarPorId(4L);
        ClientesEntity cliente = clienteDao.buscarPorId(7L);

        PedidosEntity pedido = new PedidosEntity(cliente);
        PedidosEntity pedido2 = new PedidosEntity(cliente);
        PedidosEntity pedido3 = new PedidosEntity(cliente);

        pedido.addItem(new ItemPedidoEntity(10,produto,pedido));
        pedido2.addItem(new ItemPedidoEntity(13,produto2,pedido2));
        pedido3.addItem(new ItemPedidoEntity(12,produto3,pedido3));

        em.getTransaction().begin();

        clienteDao.cadastrar(cliente);
        pedidoDao.cadastrar(pedido);
        pedidoDao.cadastrar(pedido2);
        pedidoDao.cadastrar(pedido3);

        em.getTransaction().commit();
        System.out.println(pedidoDao.valorTotalVendido());
        List<RelatorioModel> relatorioModels = pedidoDao.relatorioVendas();
        relatorioModels.forEach(e ->
                System.out.println(e.getNome() + e.getQuantidade() + e.getUltimaVenda()));
        pedidoDao.retornaPedidos().forEach(e -> System.out.println(e.getId()));
        em.close();
    }
}
