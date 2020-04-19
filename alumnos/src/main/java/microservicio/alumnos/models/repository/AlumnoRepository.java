package microservicio.alumnos.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import microservicio.commonsalumnos.models.entity.Alumno;

/**
 * AlumnoRepository
 */
public interface AlumnoRepository extends PagingAndSortingRepository<Alumno, Long> {

    @Query("SELECT a FROM Alumno a WHERE UPPER(a.nombre) LIKE UPPER(CONCAT('%',?1,'%')) or UPPER(a.apellido) LIKE UPPER(CONCAT('%',?1,'%'))")
    public List<Alumno> findByNombreOrApellido(String value);

}