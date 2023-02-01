package br.com.loja.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "produtos")
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String descricao;
    private BigDecimal preco;
    private LocalDate dataCadastro = LocalDate.now();

    @ManyToOne
    private CategoriaEntity categoria;

    public ProdutoEntity(String nome, String descricao, BigDecimal preco, CategoriaEntity categoria){
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }
}
