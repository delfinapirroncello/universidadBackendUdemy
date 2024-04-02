package com.springudemy.universidad.universidadbackend.controlador.dto;

import com.springudemy.universidad.universidadbackend.modelo.dto.AlumnoDTO;
import com.springudemy.universidad.universidadbackend.modelo.dto.PersonaDTO;
import com.springudemy.universidad.universidadbackend.modelo.dto.ProfesorDTO;
import com.springudemy.universidad.universidadbackend.modelo.mapper.mapstruct.AlumnoMapper;
import com.springudemy.universidad.universidadbackend.modelo.mapper.mapstruct.ProfesorMapper;
import com.springudemy.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/profesor")
@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "true")
public class ProfesorDtoController extends PersonaDtoController{
    public ProfesorDtoController(@Qualifier("profesorDAOImpl")PersonaDAO service, String nombre_entidad, @Autowired(required = false)AlumnoMapper alumnoMapper, ProfesorMapper profesorMapper) {
        super(service, "Profesor", alumnoMapper, profesorMapper);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerProfesorPorId(@PathVariable Integer id){
        Map<String, Object> mensaje = new HashMap<>();
        //Optional<Persona> oPersona = personaDAO.findById(id);

        //PersonaDTO dto = mapper.mapAlumno((Alumno) oPersona.get());

        mensaje.put("success", Boolean.TRUE);
        //mensaje.put("data", dto);

        return ResponseEntity.ok(mensaje);
    }

    @PostMapping
    public ResponseEntity<?> altaProfesor(@Valid @RequestBody PersonaDTO personaDTO, BindingResult result){
        Map<String, Object> mensaje = new HashMap<>();

        if (result.hasErrors()){
            mensaje.put("success", Boolean.FALSE);
            mensaje.put("validaciones", super.obtenerValidaciones(result));
            return ResponseEntity.badRequest().body(mensaje);
        }

        PersonaDTO save = super.altaPersona(profesorMapper.mapProfesor((ProfesorDTO) personaDTO));

        mensaje.put("success", Boolean.TRUE);
        mensaje.put("data", save);

        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }
}
