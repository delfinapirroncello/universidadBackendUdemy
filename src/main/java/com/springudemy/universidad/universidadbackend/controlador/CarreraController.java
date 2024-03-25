package com.springudemy.universidad.universidadbackend.controlador;

import com.springudemy.universidad.universidadbackend.exception.BadRequestException;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Carrera;
import com.springudemy.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/carreras")
public class CarreraController extends GenericController<Carrera, CarreraDAO>{

    @Autowired
    public CarreraController(CarreraDAO service) {
        super(service);
        nombreEntidad = "Carrera";
    }
/*
    @GetMapping("/{codigo}")
    public Carrera obtenerPorId(@PathVariable(value = "codigo", required = false) Integer id){
        Optional<Carrera> oCarrera = service.findById(id);
        if (!oCarrera.isPresent()){
            throw new BadRequestException(String.format("La carrera con id %d no existe", id));
        }
        return oCarrera.get();
    }
*/
    @PostMapping
    public ResponseEntity<?> altaCarrera(@Valid @RequestBody Carrera carrera, BindingResult result){
        /*if (carrera.getCantidadAnios() < 0){
            throw new BadRequestException("El campo cantidad de años no puede ser negativo");
        }
        if (carrera.getCantidadMaterias() < 0){
            throw new BadRequestException("El campo cantidad de materias no puede ser negativo");
        }*/
        //uso del BindingResult para obtener las validaciones realizadas
        Map<String, Object> validaciones = new HashMap<>();

        if (result.hasErrors()){
            //vamos a obtener una lista de nuestros errores
            result.getFieldErrors()
                    .forEach(error -> validaciones.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(validaciones);
        }
        return ResponseEntity.ok(service.save(carrera));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCarrera(@PathVariable Integer id, @RequestBody Carrera carrera){
        Map<String, Object> mensaje = new HashMap<>();
        Carrera carreraUpdate = null;
        Optional<Carrera> oCarrera = service.findById(id);

        if (!oCarrera.isPresent()){
            //throw new BadRequestException(String.format("La carrera con id %d no existe", id));
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("mensaje", String.format("%s con ID %d no existe", nombreEntidad, id));
            return ResponseEntity.badRequest().body(mensaje);
        }

        carreraUpdate = oCarrera.get();
        carreraUpdate.setCantidadAnios(carrera.getCantidadAnios());
        carreraUpdate.setCantidadMaterias(carrera.getCantidadMaterias());

        mensaje.put("datos", service.save(carreraUpdate));
        mensaje.put("success", Boolean.TRUE);

        return ResponseEntity.ok(mensaje);
    }
/*
    @DeleteMapping("/carrera/{id}")
    public void eliminarCarrera(@PathVariable Integer id){
        service.deleteById(id);
    }
*/
}
