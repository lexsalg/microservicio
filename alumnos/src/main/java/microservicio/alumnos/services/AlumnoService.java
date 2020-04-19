package microservicio.alumnos.services;

import java.util.List;

import microservicio.commons.services.CommonService;
import microservicio.commonsalumnos.models.entity.Alumno;

/**
 * AlumnoService
 */
public interface AlumnoService extends CommonService<Alumno> {

    public List<Alumno> findByNombreOrApellido(String value);

    public Iterable<Alumno> findAllById(Iterable<Long> ids);

    public void eliminarCursoAlumnoPorId(Long id);
}