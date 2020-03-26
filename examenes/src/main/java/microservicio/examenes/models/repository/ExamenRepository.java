package microservicio.examenes.models.repository;

import org.springframework.data.repository.CrudRepository;

import microservicio.examenes.models.entity.Examen;

/**
 * ExamenRepository
 */
public interface ExamenRepository extends CrudRepository<Examen, Long> {

}