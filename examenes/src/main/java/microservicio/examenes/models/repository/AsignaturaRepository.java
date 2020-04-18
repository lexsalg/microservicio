package microservicio.examenes.models.repository;

import org.springframework.data.repository.CrudRepository;

import microservicio.commonsexamenes.models.entity.Asignatura;

public interface AsignaturaRepository extends CrudRepository<Asignatura, Long> {

}