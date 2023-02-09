package br.com.loja.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RelatorioModel {
    private String nome;

    private Long quantidade;

    private LocalDate ultimaVenda;
}
