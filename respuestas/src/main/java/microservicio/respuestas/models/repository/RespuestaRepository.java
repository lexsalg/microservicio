package microservicio.respuestas.models.repository;

import org.springframework.data.repository.CrudRepository;

import microservicio.respuestas.models.entity.Respuesta;

public interface RespuestaRepository extends CrudRepository<Respuesta, Long> {

}