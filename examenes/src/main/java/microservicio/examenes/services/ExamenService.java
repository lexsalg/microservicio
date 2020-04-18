package microservicio.examenes.services;

import java.util.List;

import microservicio.commons.services.CommonService;
import microservicio.commonsexamenes.models.entity.Asignatura;
import microservicio.commonsexamenes.models.entity.Examen;

public interface ExamenService extends CommonService<Examen> {

    public List<Examen> findByNombre(String term);

    // public List<Asignatura> findAllAsignaturas();
    public Iterable<Asignatura> findAllAsignaturas();
}