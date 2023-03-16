package com.dh.clinica.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    private Integer id;
    private String nome;
    private String sobrenome;
    private Integer idade;
}
