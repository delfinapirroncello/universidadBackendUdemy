package com.springudemy.universidad.universidadbackend.modelo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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
    @NotNull
    @NotEmpty(message = "Debe de ingresar un valor")
    @Size(min = 0, max = 80)
    private String nombre;
    @Positive(message = "El valor no puede ser negativo")
    private Integer cantidad_materias;
    @Positive
    private Integer cantidad_anios;




}
