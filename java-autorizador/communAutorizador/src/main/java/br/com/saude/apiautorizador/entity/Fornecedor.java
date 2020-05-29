package br.com.saude.apiautorizador.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author danil
 */

@Getter
@Setter
public class Fornecedor implements Serializable {
    int codForn;
    int cnpjForn;
    String nomeForn;
    int codEAN;
    String nomeProd;
    int tpProd;
}
