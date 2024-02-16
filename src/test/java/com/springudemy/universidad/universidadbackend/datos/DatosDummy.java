package com.springudemy.universidad.universidadbackend.datos;

import com.springudemy.universidad.universidadbackend.modelo.entidades.Carrera;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Direccion;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Empleado;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Persona;
import com.springudemy.universidad.universidadbackend.modelo.entidades.enumeradores.TipoEmpleado;

import java.math.BigDecimal;

public class DatosDummy {

    public static Carrera carrera01(){
        return new Carrera(null, "Ingenieria en Sistemas", 50, 5);
    }

    public static Carrera carrera02(){
        return new Carrera(null, "Licenciatura en Sistemas", 45, 5);
    }

    public static Carrera carrera03(){
        return new Carrera(null, "Ingenieria Industrial", 60, 5);
    }

    public static Persona empleado01() {
        return new Empleado(null, "Lautaro", "Lopez", "25373764", new Direccion(), new BigDecimal("34434.34"), TipoEmpleado.ADMINISTRATIVO);
    }

    public static Persona empleado02() {
        return new Empleado(null, "Monica", "Fernandez", "35256465", new Direccion(), new BigDecimal("5653.65"), TipoEmpleado.ADMINISTRATIVO);
    }

    public static Persona empleado03() {
        return new Empleado(null, "Enzo", "Ramirez", "25645685", new Direccion(), new BigDecimal("8259.25"), TipoEmpleado.ADMINISTRATIVO);
    }
}
