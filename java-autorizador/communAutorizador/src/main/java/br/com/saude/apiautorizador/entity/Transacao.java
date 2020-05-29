package br.com.saude.apiautorizador.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author danil
 */

@Getter
@Setter
public class Transacao implements Serializable {
    int produto;
    String produtoNome;
    int desconto;
    int quantidade;
    int valorAPagar;
    LocalDateTime dtVenda;
}
