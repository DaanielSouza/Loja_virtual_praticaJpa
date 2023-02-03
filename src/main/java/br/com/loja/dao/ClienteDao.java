package br.com.loja.dao;

import br.com.loja.entity.ClientesEntity;
import br.com.loja.entity.PedidosEntity;

import javax.persistence.EntityManager;

public class ClienteDao {
    private EntityManager em;

    public ClienteDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(ClientesEntity clientesEntity) {
        this.em.persist(clientesEntity);
    }

    public ClientesEntity buscarPorId(Long id){
        return em.find(ClientesEntity.class,id);
    }
}
