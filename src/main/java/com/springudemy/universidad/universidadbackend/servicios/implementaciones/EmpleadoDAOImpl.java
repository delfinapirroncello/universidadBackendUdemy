package com.springudemy.universidad.universidadbackend.servicios.implementaciones;

import com.springudemy.universidad.universidadbackend.modelo.entidades.Persona;
import com.springudemy.universidad.universidadbackend.modelo.entidades.enumeradores.TipoEmpleado;
import com.springudemy.universidad.universidadbackend.repositorios.EmpleadoRepository;
import com.springudemy.universidad.universidadbackend.repositorios.PersonaRepository;
import com.springudemy.universidad.universidadbackend.servicios.contratos.EmpleadoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("empleadoDAOImpl")
public class EmpleadoDAOImpl extends PersonaDAOImpl implements EmpleadoDAO {

    @Autowired
    public EmpleadoDAOImpl(@Qualifier("repositorioEmpleados") EmpleadoRepository repository) {
        super((PersonaRepository) repository);
    }


    @Override
    public Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado) {
        return ((EmpleadoRepository)repository).findEmpleadoByTipoEmpleado(tipoEmpleado);
    }
}
