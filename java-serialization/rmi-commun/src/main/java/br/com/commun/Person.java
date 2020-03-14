package br.com.commun;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * HMI - HighSchool
 *
 */

@Getter 
@Setter 
@NoArgsConstructor
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String telephone;
    private String citie;
}
