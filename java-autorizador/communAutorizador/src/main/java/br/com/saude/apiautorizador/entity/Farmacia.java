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
public class Farmacia implements Serializable {
    int codFarm;
    int codFili;
    int cnpjFarm;
    String nomeFarm;
    String matrizFarm;
}
