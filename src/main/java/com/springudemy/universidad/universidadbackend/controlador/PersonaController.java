package com.springudemy.universidad.universidadbackend.controlador;

import com.springudemy.universidad.universidadbackend.exception.BadRequestException;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Persona;
import com.springudemy.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

public class PersonaController extends GenericController<Persona, PersonaDAO> {

    public PersonaController(PersonaDAO service){
        super(service);
    }

    //buscar por Nombre y Apellido
    @GetMapping("/nombre-apellido")
    public ResponseEntity<?> buscarPorNombreYApellido(@RequestParam String nombre, @RequestParam String apellido){
        Map<String, Object> mensaje =new HashMap<>();
        Optional<Persona> oPersona = service.buscarPorNombreYApellido(nombre, apellido);
        if (!oPersona.isPresent()){
            //throw new BadRequestException(String.format("No se encontro Persona con nombre %s y apellido %s", nombre, apellido));
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("No se encontro Persona con nombre %s y apellido %s", nombre, apellido));
            return ResponseEntity.badRequest().body(mensaje);
        }
        mensaje.put("success", Boolean.TRUE);
        mensaje.put("datos", oPersona.get());

        return ResponseEntity.ok(mensaje);
    }

    //buscar por Apellido
    @GetMapping("/apellido")
    public List <Persona> buscarPorApellido(@RequestParam String apellido){
        List<Persona> personas = (List<Persona>) service.buscarPersonasPorApellido(apellido);
        if (personas.isEmpty()) throw new BadRequestException(String.format("No se encontro Persona con nombre %s y apellido %s", apellido));
        return personas;
    }

    //buscar por Dni
    @GetMapping("/dni/{dni}")
    public Persona buscarPorDni(@PathVariable String dni){
        Optional<Persona> oPersona = service.buscarPorDni(dni);
        if (!oPersona.isPresent()) throw new BadRequestException(String.format("La persona con dni %s no existe",dni));
        return oPersona.get();
    }

    //obtener Por Id
    @GetMapping("/persona/{id}")
    public Persona obtenerPorId(@PathVariable("id") Integer id) {
        Optional<Persona> oPersona = service.findById(id);
        if (!oPersona.isPresent()){
            throw new BadRequestException(String.format("No se encontró Persona con ID %d", id));
        }
        return oPersona.get();
    }

    //eliminar Por Id
    @DeleteMapping("/eliminar/{id}")
    public void eliminarPersonaPorId(@PathVariable("id") Integer id) {
        service.deleteById(id);
    }

    //altaEntidad
    @PostMapping("/alta/{id}")
    public Persona altaEntidad(@PathVariable("id") Integer id){
        Persona nuevaPersona = new Persona();
        nuevaPersona.setId(id);
        return altaEntidad(nuevaPersona);
    }


}
