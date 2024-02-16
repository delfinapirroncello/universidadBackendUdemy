/*package com.springudemy.universidad.universidadbackend.comandos;

import com.springudemy.universidad.universidadbackend.modelo.entidades.Alumno;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Carrera;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Persona;
import com.springudemy.universidad.universidadbackend.servicios.contratos.AlumnoDAO;
import com.springudemy.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import com.springudemy.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AlumnosCommand implements CommandLineRunner {

    @Autowired
    @Qualifier("alumnoDAOImpl")
    private PersonaDAO personaDAO;
    @Autowired
    private CarreraDAO carreraDAO;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("--------- ************ Alumnos Command ************ ---------");

        System.out.println("--- Busqueda de Personas por Apellido");

        Iterable<Persona> iPersona = personaDAO.buscarPersonaPorApellido(ObjetosDummy.getAlumnoDos().getApellido());

        iPersona.forEach(System.out::println);

        System.out.println("--- Busqueda de Persona por DNI");

        Optional<Persona> oPersona = personaDAO.buscarPorDni(ObjetosDummy.getEmpleadoUno().getDni());

        if(oPersona.isPresent()){
            System.out.println(oPersona.get().toString());
        }

        System.out.println("--- Busqueda de Persona por Nombre y Apellido");

        Optional<Persona> oPersonaDos = personaDAO.buscarPorNombreYApellido(ObjetosDummy.getProfesorDos().getNombre(), ObjetosDummy.getProfesorDos().getApellido());

        if(oPersona.isPresent()){
            System.out.println(oPersonaDos.get().toString());
            ;
        }

        System.out.println("--- Busqueda de Alumnos por Carrera");

        Iterable<Persona> iAlumnos = ((AlumnoDAO) personaDAO).buscarAlumnosPorNombreCarrera(ObjetosDummy.getCarreraIngMec().getNombre());

        iAlumnos.forEach(System.out::println);

        Optional<Carrera> ingSistemas = carreraDAO.findById(2);

        Iterable<Persona> alumnos = personaDAO.findAll();
        alumnos.forEach(alumno -> ((Alumno)alumno).setCarrera(ingSistemas.get()));
        alumnos.forEach(alumno -> personaDAO.save(alumno));

       // Optional<Persona> alumno_1 = personaDAO.findById(1);

        /*Optional<Persona> personaNomApe = personaDAO.buscarPorNombreYApellido(alumno_1.get().getNombre(), alumno_1.get().getApellido());
        System.out.println(personaNomApe.toString());

        Optional<Persona> personaDni = personaDAO.buscarPorDni(alumno_1.get().getDni());
        System.out.println(personaDni.toString());

        Iterable<Persona> personasApellido = personaDAO.buscarPersonaPorApellido(alumno_1.get().getApellido());
        if (personasApellido != null) {
            personasApellido.forEach(System.out::println);
        } else {
            System.out.println("No se encontraron personas con ese apellido.");
        }*/


       /* Optional<Carrera> ingSistemas = carreraDAO.findById(2);

        Iterable<Persona> alumnosCarrera = ((AlumnoDAO)personaDAO).buscarAlumnosPorNombreCarrera(ingSistemas.get().getNombre());
        alumnosCarrera.forEach(System.out::println);
    }
}
*/