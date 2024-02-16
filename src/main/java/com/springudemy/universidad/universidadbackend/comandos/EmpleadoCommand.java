/*package com.springudemy.universidad.universidadbackend.comandos;

import com.springudemy.universidad.universidadbackend.modelo.entidades.Persona;
import com.springudemy.universidad.universidadbackend.modelo.entidades.enumeradores.TipoEmpleado;
import com.springudemy.universidad.universidadbackend.servicios.contratos.EmpleadoDAO;
import com.springudemy.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;

public class EmpleadoCommand implements CommandLineRunner {

    @Autowired
    @Qualifier(value = "empleadoDAOImple")
    private PersonaDAO servicioEmpleado;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("--------- ************ Empleados Command ************ ---------");

        Iterable<Persona> iEmpleado = ((EmpleadoDAO) servicioEmpleado).findEmpleadoByTipoEmpleado(TipoEmpleado.ADMINISTRATIVO);

        iEmpleado.forEach(System.out::println);
    }
}*/
