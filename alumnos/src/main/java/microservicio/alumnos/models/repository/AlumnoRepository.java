package microservicio.alumnos.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import microservicio.commonsalumnos.models.entity.Alumno;

/**
 * AlumnoRepository
 */
public interface AlumnoRepository extends PagingAndSortingRepository<Alumno, Long> {

    @Query("SELECT a FROM Alumno a WHERE a.nombre LIKE %?1% or a.apellido LIKE %?1%")
    public List<Alumno> findByNombreOrApellido(String value);

}