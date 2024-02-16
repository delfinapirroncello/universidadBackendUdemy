/*package com.springudemy.universidad.universidadbackend.comandos;

import com.springudemy.universidad.universidadbackend.modelo.entidades.Carrera;
import com.springudemy.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CarreraComandos implements CommandLineRunner {

    @Autowired
    private CarreraDAO servicio;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- Carreras Command ---");

        /*System.out.println("-Buscar carrera por Cantidad de años");

            Iterable<Carrera> iCarreras = servicio.findCarrerasByCantidadAniosAfter(ObjetosDummy.getCarreraIngMec().getCantidadAnios());

        iCarreras.forEach(System.out::println);

        System.out.println("--------- Buscar carreras por nombre");

        Iterable<Carrera> iCarrerasByNombre = servicio.findCarrerasByNombreContains("Economia");

        iCarrerasByNombre.forEach(System.out::println);

        System.out.println("--------- Buscar carreras por nombre ignorecase");

        Iterable<Carrera> iCarrerasByNomIC = servicio.findCarrerasByNombreContainsIgnoreCase("Mecanica");

        iCarrerasByNomIC.forEach(System.out::println);

        /*Carrera ingSistemas = new Carrera(null, "Ingenieria en Sistemas", 60, 5);
        Carrera ingIndustrial = new Carrera(null, "Ingenieria Industrial", 55, 5);
        Carrera ingAlimentos = new Carrera(null, "Ingenieria en Alimentos", 53, 5);
        Carrera ingElectronica = new Carrera(null, "Ingenieria Electronica", 45, 5);
        Carrera licSistemas = new Carrera(null, "Licenciatura en Sistemas", 33, 3);
        Carrera licTurismo = new Carrera(null, "Licenciatura en Turismo", 40,4 );
        Carrera licYoga = new Carrera(null, "Licenciatura en Yoga", 42, 4);
        Carrera licRecursos = new Carrera(null, "Licenciatura en Recursos Humanos - RRHH", 25, 3);

        servicio.save(ingSistemas);
        servicio.save(ingAlimentos);
        servicio.save(ingElectronica);
        servicio.save(ingIndustrial);
        servicio.save(licSistemas);
        servicio.save(licTurismo);
        servicio.save(licYoga);
        servicio.save(licRecursos);*/

    /*List<Carrera> carreras = (List<Carrera>)servicio.findCarrerasByNombreContains("Sistemas");
    carreras.forEach(System.out::println);

    List<Carrera> carrerasIgnoreCase1 = (List<Carrera>) servicio.findCarrerasByNombreContainsIgnoreCase("SISTEMAS");
    List<Carrera> carrerasIgnoreCase2 = (List<Carrera>) servicio.findCarrerasByNombreContainsIgnoreCase("sistemas");
    carrerasIgnoreCase1.forEach(System.out::println);
    carrerasIgnoreCase2.forEach(System.out::println);*/

        /*List<Carrera> carrerasPorAnio = (List<Carrera>) servicio.findCarrerasByCantidadAniosAfter(3);
        carrerasPorAnio.forEach(System.out::println);
    }
}
*/