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
public class Beneficiario implements Serializable {
    int codBeneficiario;
    int cpfBeneficiario;
    String nomeBeneficiario;
    String sexoBeneficiario;
}
