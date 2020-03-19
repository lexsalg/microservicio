package microservicio.cursos.services;

import org.springframework.stereotype.Service;

import microservicio.commons.services.CommonServiceImpl;
import microservicio.cursos.models.entity.Curso;
import microservicio.cursos.models.repository.CursoRepository;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {

}