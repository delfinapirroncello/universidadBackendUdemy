package com.springudemy.universidad.universidadbackend.modelo.dto;

import lombok.*;

//agrego get y set a traves de codigo con lombok (simplifica codigo) @Setter @Getter
//agrego el contructor con lombok
@NoArgsConstructor
//agrego los argumentos con lombok
@AllArgsConstructor
//nos permite tener todo lo necesario
@Data
//to string @ToString
//equals and hascode @EqualsAndHashCode
public class CarreraDTO {

    //ATRIBUTOS
    private Integer codigo;
    private String nombre;
    private Integer cantidad_materias;
    private Integer cantidad_anios;




}
