package microservicio.examenes.models.repository;

import org.springframework.data.repository.CrudRepository;

import microservicio.commonsexamenes.models.entity.Examen;

/**
 * ExamenRepository
 */
public interface ExamenRepository extends CrudRepository<Examen, Long> {

}