package microservicio.cursos.models.repository;

import org.springframework.data.repository.CrudRepository;

import microservicio.cursos.models.entity.Curso;

/**
 * CursoRepository
 */
public interface CursoRepository extends CrudRepository<Curso, Long> {

}