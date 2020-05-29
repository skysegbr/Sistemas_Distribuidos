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
public class Autorizacao implements Serializable {

    int codAutorizacao;
    int ordemItem;
    int codFarm;
    int codFili;
    int cnpjFarm;
    int codBeneficiario;
    int codPlas;
    int cnpjPlas;
    int codProd;
    int precoFarm;
    int precoLab;
    int precoPmc_saude;
    int precoAPagar;
    int staCaptura;
    LocalDateTime dtCutorizacao;
}
