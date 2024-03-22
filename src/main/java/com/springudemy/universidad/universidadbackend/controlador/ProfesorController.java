package com.springudemy.universidad.universidadbackend.controlador;

import com.springudemy.universidad.universidadbackend.exception.BadRequestException;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Alumno;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Carrera;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Persona;
import com.springudemy.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import com.springudemy.universidad.universidadbackend.servicios.contratos.PersonaDAO;
import com.springudemy.universidad.universidadbackend.servicios.contratos.ProfesorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/profesor")
public class ProfesorController extends PersonaController{

    private final CarreraDAO carreraDAO;
    private PersonaDAO personaDAO;

    @Autowired
    public ProfesorController(@Qualifier("profesorDAOImpl")PersonaDAO profesorDAO, CarreraDAO carreraDAO) {
        super(profesorDAO);
        nombreEntidad = "Profesor";
        this.personaDAO = profesorDAO;
        this.carreraDAO = carreraDAO;
    }

/*
    //Obtener Todos
    @GetMapping
    public ResponseEntity<?> obtenerTodos(){
        Map<String, Object> profesor = new HashMap<>();
        List<E> listaProfesor = (List<E>) service.findAll();

        if (listaProfesor.isEmpty()) {
            //throw new BadRequestException("No existen profesores");
            profesor.put("success", Boolean.FALSE);
            profesor.put("mensaje", String.format("No existe %ss", nombreEntidad));
            return ResponseEntity.badRequest().body(profesor);
        }
    }
*/
    //actualizar Profesor
    @PutMapping("/update/{id}")
    public Persona actualizarProfesor(@PathVariable Integer id, @RequestBody Persona profesor){
        Persona profesorUpdate = null;
        Optional<Persona> oProfesor = service.findById(id);
        if (!oProfesor.isPresent()){
            throw new BadRequestException(String.format("Profesor con id %d no existe", id));
        }
        profesorUpdate = oProfesor.get();
        profesorUpdate.setNombre(profesor.getNombre());
        profesorUpdate.setApellido(profesor.getApellido());
        profesorUpdate.setDireccion(profesor.getDireccion());
        return service.save(profesorUpdate);
    }


    //Eliminar profesor
    @DeleteMapping("/delete/{id}")
    public void eliminarProfesor(@PathVariable Integer id){
        personaDAO.deleteById(id);
    }

    //Agregar profesor
    @PostMapping("/profesor")
    public Persona altaEntidad(@RequestBody Persona profesor){
        Persona nuevaPersona = new Persona();
        nuevaPersona.setId(profesor.getId());
        return altaEntidad(nuevaPersona);
    }
}
