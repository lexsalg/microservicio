package microservicio.alumnos.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import microservicio.alumnos.models.repository.AlumnoRepository;
import microservicio.commons.services.CommonServiceImpl;
import microservicio.commonsalumnos.models.entity.Alumno;

/**
 * AlumnoServiceImpl
 */
@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements AlumnoService {

    @Override
    @Transactional(readOnly = true)
    public List<Alumno> findByNombreOrApellido(String value) {

        return repository.findByNombreOrApellido(value);
    }

}