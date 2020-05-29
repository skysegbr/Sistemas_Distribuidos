package br.com.saude.apiautorizador.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Danilo Segura
 */

@Getter
@Setter
public class PlanoSaude implements Serializable {
    int codPlas;
    int cnpjPlas;
    String nomePlas;
}
