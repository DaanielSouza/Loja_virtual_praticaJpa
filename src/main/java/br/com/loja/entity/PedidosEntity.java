package br.com.loja.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedidos")
public class PedidosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDate data = LocalDate.now();
    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @ManyToOne
    private ClientesEntity cliente;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<ItemPedidoEntity> itens = new ArrayList<>();

    public PedidosEntity(ClientesEntity cliente) {
        this.cliente = cliente;
    }

    public void addItem(ItemPedidoEntity item){
        item.setPedido(this);
        this.itens.add(item);
    }

}
