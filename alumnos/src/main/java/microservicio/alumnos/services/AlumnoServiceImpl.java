package microservicio.alumnos.services;

import org.springframework.stereotype.Service;

import microservicio.alumnos.models.entity.Alumno;
import microservicio.alumnos.models.repository.AlumnoRepository;
import microservicio.commons.services.CommonServiceImpl;

/**
 * AlumnoServiceImpl
 */
@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements AlumnoService {

}