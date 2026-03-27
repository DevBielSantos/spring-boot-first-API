package br.com.gabriel.spring_boot_essentials.dto;

import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class ProdutoDto {

    private String nome;
    private BigDecimal valor;
    private Integer quantidade;
}
