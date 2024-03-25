package com.springudemy.universidad.universidadbackend.controlador;

import com.springudemy.universidad.universidadbackend.exception.BadRequestException;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Persona;
import com.springudemy.universidad.universidadbackend.servicios.contratos.GenericoDAO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GenericController <E, S extends GenericoDAO<E>>{

    protected final S service;
    protected String nombreEntidad;


    public GenericController(S service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> obtenerTodos(){
        Map<String, Object> mensaje = new HashMap<>();
        List<E> listado = (List<E>) service.findAll();

        if (listado.isEmpty()){
            //throw new BadRequestException(String.format("No se han encontrado %ss", nombreEntidad));
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("No existen %ss", nombreEntidad));
            return ResponseEntity.badRequest().body(mensaje);
        }

        mensaje.put("success",Boolean.TRUE);
        mensaje.put("datos",listado);
        return ResponseEntity.ok(mensaje);
    }

    //obtenerPorId (Id)
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPersonaPorId(@PathVariable("id") Integer id){
        Optional<E> oPersona = service.findById(id);

        if (!oPersona.isPresent()){
            //throw  new BadRequestException(String.format("%s con ID %d no encontrado", nombreEntidad, id));
            Map<String, Object> mensaje = new HashMap<>();

            mensaje.put("mensaje", String.format("%s con ID %d no encontrado", nombreEntidad, id));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }
        return ResponseEntity.ok(oPersona.get());
    }

    //borrarEntidadPorId (Id)
    @DeleteMapping("/{id}")
    public void eliminarPorId(@PathVariable("id") Integer id){
        service.deleteById(id);
    }

    //altaEntidad
    @PostMapping("/altaEntidad/{id}")
    //altaEntidad (Entidad)
    public Persona altaEntidad(@RequestBody Persona persona){
        /*if (){
            throw new BadRequestException("La persona ya existe");
        } */
        return (Persona) service.save((E) persona);
    }

}
