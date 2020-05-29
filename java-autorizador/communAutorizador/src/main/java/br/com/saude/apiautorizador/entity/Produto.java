package br.com.saude.apiautorizador.entity;

import java.io.Serializable;
//import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Danilo Segura
 */

@Getter
@Setter
public class Produto implements Serializable {
    int codProd;
    int tpProduto;
    String nomeProd;
}
