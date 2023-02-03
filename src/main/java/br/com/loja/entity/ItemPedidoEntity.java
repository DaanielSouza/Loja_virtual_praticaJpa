package br.com.loja.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "itens_pedido")
public class ItemPedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "preco_unitario")
    private BigDecimal precoUnitario;
    private Integer quantidade;

    @ManyToOne
    private ProdutoEntity produto;
    @ManyToOne
    private PedidosEntity pedido;

    public ItemPedidoEntity(Integer quantidade, ProdutoEntity produto, PedidosEntity pedido) {
        this.quantidade = quantidade;
        this.produto = produto;
        this.pedido = pedido;
        this.precoUnitario = produto.getPreco();
    }
}
