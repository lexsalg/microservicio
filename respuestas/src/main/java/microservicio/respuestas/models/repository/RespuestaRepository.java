package microservicio.respuestas.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import microservicio.respuestas.models.entity.Respuesta;

public interface RespuestaRepository extends CrudRepository<Respuesta, Long> {

    // FECTH paraque traiga todos los objetos relacionados
    // @Query("SELECT r FROM Respuesta r JOIN FETCH r.alumno a JOIN FETCH r.pregunta
    // p JOIN FETCH p.examen e WHERE a.id=?1 AND e.id=?2")
    @Query("SELECT r FROM Respuesta r JOIN FETCH  r.pregunta p JOIN FETCH p.examen e WHERE r.alumnoId=?1 AND e.id=?2")
    public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumnoId, Long examenId);

    // @Query("SELECT e.id FROM Respuesta r JOIN r.alumno a JOIN r.pregunta p JOIN
    // p.examen e WHERE a.id=?1 GROUP BY e.id")
    @Query("SELECT e.id FROM Respuesta r JOIN r.pregunta p JOIN p.examen e WHERE r.alumnoId=?1 GROUP BY e.id")
    public Iterable<Long> findExamenesIdsConRespuestasByAlumno(Long alumnoId);

}