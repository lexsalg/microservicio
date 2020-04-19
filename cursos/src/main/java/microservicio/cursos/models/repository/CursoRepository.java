package microservicio.cursos.models.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import microservicio.cursos.models.entity.Curso;

/**
 * CursoRepository
 */
// public interface CursoRepository extends CrudRepository<Curso, Long> {
public interface CursoRepository extends PagingAndSortingRepository<Curso, Long> {

    // @Query("SELECT c FROM Curso c JOIN FETCH  c.alumnos a WHERE a.id=?1")
    @Query("SELECT c FROM Curso c JOIN FETCH  c.cursoAlumnos a WHERE a.alumnoId=?1")
    public Curso findCursoByAlumnoId(Long id);


    @Modifying
    @Query("DELETE FROM CursoAlumno ca WHERE ca.alumnoId=?1")
    public void eliminarCursoAlumnoPorId(Long id);
}