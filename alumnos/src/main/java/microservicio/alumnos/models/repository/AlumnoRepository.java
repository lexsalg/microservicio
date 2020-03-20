package microservicio.alumnos.models.repository;

import org.springframework.data.repository.CrudRepository;

import microservicio.commonsalumnos.models.entity.Alumno;

/**
 * AlumnoRepository
 */
public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

}