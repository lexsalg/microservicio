package microservicio.alumnos.services;

import org.springframework.stereotype.Service;

import microservicio.alumnos.models.repository.AlumnoRepository;
import microservicio.commons.services.CommonServiceImpl;
import microservicio.commonsalumnos.models.entity.Alumno;

/**
 * AlumnoServiceImpl
 */
@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements AlumnoService {

}