package microservicio.cursos.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import microservicio.cursos.models.entity.Curso;

/**
 * CursoRepository
 */
public interface CursoRepository extends CrudRepository<Curso, Long> {

    @Query("SELECT c FROM Curso c JOIN FETCH  c.alumnos a WHERE a.id=?1")
    public Curso findCursoByAlumnoId(Long id);

}