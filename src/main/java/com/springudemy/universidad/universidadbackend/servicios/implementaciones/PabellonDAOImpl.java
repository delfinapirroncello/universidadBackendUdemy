package com.springudemy.universidad.universidadbackend.servicios.implementaciones;

import com.springudemy.universidad.universidadbackend.modelo.entidades.Pabellon;
import com.springudemy.universidad.universidadbackend.repositorios.PabellonRepository;
import com.springudemy.universidad.universidadbackend.servicios.contratos.PabellonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PabellonDAOImpl extends GenericoDAOImpl<Pabellon, PabellonRepository> implements PabellonDAO{
    @Autowired
    public PabellonDAOImpl(PabellonRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly =true)
    public Iterable<Pabellon> buscarPabellonPorLocalidad(String localidad) {
        return repository.findPabellonByDireccion_Localidad(localidad);
    }

    @Override
    public Optional<Pabellon> findPabellonByNombreIgnoreCase(String nombre) {
        return repository.findPabellonByNombreIgnoreCase(nombre);
    }

    @Override
    public Iterable<Pabellon> findPabellonByFechaAltaBetween(LocalDateTime desde, LocalDateTime hasta) {
        return repository.findPabellonByFechaAltaBetween(desde,hasta);
    }
}
