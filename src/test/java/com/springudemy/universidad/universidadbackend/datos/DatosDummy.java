package com.springudemy.universidad.universidadbackend.datos;

import com.springudemy.universidad.universidadbackend.modelo.entidades.*;
import com.springudemy.universidad.universidadbackend.modelo.entidades.enumeradores.Pizarron;
import com.springudemy.universidad.universidadbackend.modelo.entidades.enumeradores.TipoEmpleado;

import java.math.BigDecimal;

public class DatosDummy {

    public static Carrera carrera01(boolean conId){
        Carrera carrera = (conId) ? new Carrera(1, "Ingenieria en Sistemas", 50, 5) :
        new Carrera(null, "Ingenieria en Sistemas", 50, 5);
        return carrera;
    }

    public static Carrera carrera02(){
        return new Carrera(null, "Licenciatura en Sistemas", 45, 4);
    }

    public static Carrera carrera03(boolean conId){
        Carrera carrera = (conId) ? new Carrera(3, "Ingenieria Industrial", 60, 5) :
                new Carrera(null, "Ingenieria Industrial", 60, 5);
        return carrera;
    }

    public static Persona empleado01() {
        return new Empleado(null, "Lautaro", "Lopez", "25373764", new Direccion(), new BigDecimal("34434.34"), TipoEmpleado.ADMINISTRATIVO);
    }

    public static Persona empleado02() {
        return new Empleado(null, "Monica", "Fernandez", "35256465", new Direccion(), new BigDecimal("5653.65"), TipoEmpleado.MANTENIMIENTO);
    }

    public static Persona profesor01(){
        return new Profesor(null, "Martin", "Lugone", "384644793", new Direccion(), new BigDecimal("60000.00"));
    }

    public static Persona alumno01(){
        return new Alumno(null, "Jhon", "Benediz", "43944994", new Direccion());
    }

    public static Persona alumno02(){
        return new Alumno(null, "Andres", "Benediz", "43948884", new Direccion());
    }

    public static Persona alumno03(){
        return new Alumno(null, "Joaquin", "Leon", "43853394", new Direccion());
    }

    public static Aula getAula123(){
        return new Aula(null, 123, "24 x 36", 50, Pizarron.PIZARRA_BLANCA);
    }

    public static Pabellon getPabellonUno(){
        return new Pabellon(null, 450.5, "Pabellon Uno", new Direccion("Calle Uno", "1453", "1623", "", "", "Rodriguez Peña"));
    }
}
