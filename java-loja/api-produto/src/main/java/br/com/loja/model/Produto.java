package br.com.loja.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document
public class Produto {

    @Id
    private int id;
    private String nome;
}
