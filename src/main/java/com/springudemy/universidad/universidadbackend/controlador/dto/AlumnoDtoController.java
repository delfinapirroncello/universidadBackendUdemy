package com.springudemy.universidad.universidadbackend.controlador.dto;

import com.springudemy.universidad.universidadbackend.modelo.dto.AlumnoDTO;
import com.springudemy.universidad.universidadbackend.modelo.dto.PersonaDTO;
import com.springudemy.universidad.universidadbackend.modelo.mapper.mapstruct.AlumnoMapper;
import com.springudemy.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import jakarta.validation.Valid;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/alumnos")
@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "true")
public class AlumnoDtoController extends PersonaDtoController {

    public AlumnoDtoController(PersonaDAO service, AlumnoMapper alumnoMapper) {
        super(service, "Alumno", alumnoMapper);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerAlumnoPorId(@PathVariable Integer id){
        Map<String, Object> mensaje = new HashMap<>();

        PersonaDTO dto = super.buscarPersonaPorId(id);

        if(dto == null) {
            mensaje.put("succes", Boolean.FALSE);
            mensaje.put("mensaje", String.format("No existe %s con ID %d", nombre_entidad, id));
            return ResponseEntity.badRequest().body(mensaje);
        }

        mensaje.put("success", Boolean.TRUE);
        mensaje.put("data", dto);

        return ResponseEntity.ok(mensaje);
    }

    @PostMapping
    public ResponseEntity<?> altaAlumno(@Valid @RequestBody PersonaDTO personaDTO, BindingResult result){
        Map<String, Object> mensaje = new HashMap<>();

        if(result.hasErrors()) {
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("validaciones", super.obtenerValidaciones(result));
            return ResponseEntity.badRequest().body(mensaje);
        }

        PersonaDTO save = super.altaPersona(alumnoMapper.mapAlumno((AlumnoDTO) personaDTO));

        mensaje.put("succes", Boolean.TRUE);
        mensaje.put("data", save);

        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }


}