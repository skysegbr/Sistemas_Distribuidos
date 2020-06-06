package br.com.loja.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Cliente {

    @Id
    private int id;
    private String nome;
    private String telefone;
}
