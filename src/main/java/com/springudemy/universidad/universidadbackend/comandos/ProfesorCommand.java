/*package com.springudemy.universidad.universidadbackend.comandos;

import com.springudemy.universidad.universidadbackend.modelo.entidades.Persona;
import com.springudemy.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import com.springudemy.universidad.universidadbackend.servicios.contratos.ProfesorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
public class ProfesorCommand implements CommandLineRunner {

    @Autowired
    @Qualifier(value = "profesorDAOImple")
    private PersonaDAO servicioProfesor;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--------- ************ Profesores Command ************ ---------");

        /*Iterable<Persona> iProfesor = ((ProfesorDAO) servicioProfesor).findProfesoresByCarrera(ObjetosDummy.getCarreraIngMec().getNombre());

        iProfesor.forEach(System.out::println);
    }
}*/
