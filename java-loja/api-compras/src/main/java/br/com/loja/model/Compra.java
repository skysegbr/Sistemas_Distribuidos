package br.com.loja.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document
public class Compra {
    private int id;
    private String descricao;
    private Fornecedor fornecedor;
    private Produto produto;
}