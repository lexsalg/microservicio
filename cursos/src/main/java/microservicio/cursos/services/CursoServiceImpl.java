package microservicio.cursos.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import microservicio.commons.services.CommonServiceImpl;
import microservicio.cursos.models.entity.Curso;
import microservicio.cursos.models.repository.CursoRepository;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {

    @Override
    @Transactional(readOnly = true)
    public Curso findCursoByAlumnoId(Long id) {

        return repository.findCursoByAlumnoId(id);
    }

}