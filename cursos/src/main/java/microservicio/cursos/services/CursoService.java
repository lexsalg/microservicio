package microservicio.cursos.services;

import microservicio.commons.services.CommonService;
import microservicio.cursos.models.entity.Curso;

/**
 * CursoService
 */
public interface CursoService extends CommonService<Curso> {
    public Curso findCursoByAlumnoId(Long id);

    public Iterable<Long> obtenerExamenesIdsConRespuestasAlumno(Long alumnoId);
}