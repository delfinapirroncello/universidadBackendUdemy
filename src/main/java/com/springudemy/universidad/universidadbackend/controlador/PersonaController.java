package com.springudemy.universidad.universidadbackend.controlador;

import com.springudemy.universidad.universidadbackend.exception.BadRequestException;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Persona;
import com.springudemy.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Deprecated
public class PersonaController extends GenericController<Persona, PersonaDAO> {

    public PersonaController(PersonaDAO service){
        super(service);
    }

    @GetMapping("/nombre-apellido")
    public ResponseEntity<?> buscarPersonaPorNombreYApellido(@RequestParam String nombre, @RequestParam String apellido){
        Map<String, Object> mensaje = new HashMap<>();
        Optional<Persona> oPersona = service.buscarPorNombreYApellido(nombre, apellido);
        if(!oPersona.isPresent()) {
            //throw new BadRequestException(String.format("No se encontro Persona con nombre %s y apellido %s", nombre, apellido));
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("No se encontro Persona con nombre %s y apellido %s", nombre, apellido));
            return ResponseEntity.badRequest().body(mensaje);
        }

        mensaje.put("success", Boolean.TRUE);
        mensaje.put("datos", oPersona.get());

        return ResponseEntity.ok(mensaje);
    }
}
