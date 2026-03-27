package br.com.gabriel.spring_boot_essentials.database.model;

import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class ProdutoEntity {

    private Integer id;
    private String nome;
    private BigDecimal valor;
    private Integer quantidade;
}
