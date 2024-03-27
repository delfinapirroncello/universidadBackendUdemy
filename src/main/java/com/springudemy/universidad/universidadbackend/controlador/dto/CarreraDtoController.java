package com.springudemy.universidad.universidadbackend.controlador.dto;


import com.springudemy.universidad.universidadbackend.modelo.dto.CarreraDTO;
import com.springudemy.universidad.universidadbackend.modelo.entidades.Carrera;
import com.springudemy.universidad.universidadbackend.modelo.mapper.mapstruct.CarreraMapperMS;
import com.springudemy.universidad.universidadbackend.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carreras")
@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "true")
public class CarreraDtoController {

    @Autowired
    private CarreraDAO carreraDAO;
    @Autowired
    private CarreraMapperMS mapper;

    @GetMapping
    public ResponseEntity<?> obtenerTodos(){
        Map<String,Object> mensaje = new HashMap();
        List<Carrera> carreras = (List<Carrera>) carreraDAO.findAll();

        List<CarreraDTO> carreraDTOS = carreras
                .stream()
                .map(mapper::mapCarrera)
                .collect(Collectors.toList());

        mensaje.put("success", Boolean.TRUE);
        mensaje.put("data", carreraDTOS);

        return ResponseEntity.ok(mensaje);
    }

}
