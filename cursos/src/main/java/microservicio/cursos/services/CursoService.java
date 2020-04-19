package microservicio.cursos.services;

import java.util.List;

import microservicio.commons.services.CommonService;
import microservicio.commonsalumnos.models.entity.Alumno;
import microservicio.cursos.models.entity.Curso;

/**
 * CursoService
 */
public interface CursoService extends CommonService<Curso> {

    public Curso findCursoByAlumnoId(Long id);

    public Iterable<Long> obtenerExamenesIdsConRespuestasAlumno(Long alumnoId);

    public Iterable<Alumno> obtenerAlumnosPorCurso(List<Long> ids);

    public void eliminarCursoAlumnoPorId(Long id);
}