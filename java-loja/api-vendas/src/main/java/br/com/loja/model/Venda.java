package br.com.loja.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document
public class Venda {
    @Id
    private int id;
    private String descricaoVenda;
    private String dataVenda;
    private Produto produto;
    private Cliente cliente;
}