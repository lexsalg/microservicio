package microservicio.alumnos.services;

import java.util.Optional;
import microservicio.alumnos.models.entity.Alumno;

/**
 * AlumnoService
 */
public interface AlumnoService {

    public Iterable<Alumno> findAll();

    public Optional<Alumno> findById(Long id);

    public Alumno save(Alumno alumno);

    public void deleteById(Long id);
}