package br.com.gabriel.spring_boot_essentials.service;

import br.com.gabriel.spring_boot_essentials.database.model.ProdutoEntity;
import br.com.gabriel.spring_boot_essentials.dto.ProdutoDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



@Service
public class ProdutoService {

    private static final List<ProdutoEntity> PRODUTOS = new ArrayList<>();

    static {
        PRODUTOS.add(ProdutoEntity.builder()
                .id(1)
                .nome("Notebook")
                .valor(new BigDecimal("5000"))
                .quantidade(10)
                .build());

        PRODUTOS.add(ProdutoEntity.builder()
                .id(2)
                .nome("Iphone")
                .valor(new BigDecimal("7000"))
                .quantidade(10)
                .build());
        PRODUTOS.add(ProdutoEntity.builder()
                .id(3)
                .nome("Mouse")
                .valor(new BigDecimal("500"))
                .quantidade(10)
                .build());
    }

    public List<ProdutoEntity> findAll() {
        return new ArrayList<>(PRODUTOS);
    }

    public ProdutoEntity createProduct(ProdutoDto produtoDto) {

        Integer identificador = PRODUTOS.stream()
                .mapToInt(ProdutoEntity::getId)
                .max()
                .orElse(0) + 1;

        ProdutoEntity novoProduto = ProdutoEntity.builder()
                .id(identificador)
                .nome(produtoDto.getNome())
                .valor(produtoDto.getValor())
                .quantidade(produtoDto.getQuantidade())
                .build();
        PRODUTOS.add(novoProduto);
        return novoProduto;
    }

    public ProdutoEntity atualizarProduto(ProdutoDto produtoDto, Integer id) {
        ProdutoEntity produto = PRODUTOS.stream()
                .filter(p -> p.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setNome(produtoDto.getNome());
        produto.setValor(produtoDto.getValor());
        produto.setQuantidade(produtoDto.getQuantidade());

        return produto;
    }

    public void removerProduct(Integer id) {
        PRODUTOS.removeIf(p -> p.getId().equals(id));
    }


}
