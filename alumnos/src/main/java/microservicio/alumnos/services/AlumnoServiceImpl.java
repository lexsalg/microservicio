package microservicio.alumnos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import microservicio.alumnos.clients.CursoFeignClient;
import microservicio.alumnos.models.repository.AlumnoRepository;
import microservicio.commons.services.CommonServiceImpl;
import microservicio.commonsalumnos.models.entity.Alumno;

/**
 * AlumnoServiceImpl
 */
@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements AlumnoService {

    @Autowired
    private CursoFeignClient clientCurso;

    @Override
    @Transactional(readOnly = true)
    public List<Alumno> findByNombreOrApellido(String value) {
        return repository.findByNombreOrApellido(value);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Alumno> findAllById(Iterable<Long> ids) {
        return repository.findAllById(ids);
    }

    @Override
    public void eliminarCursoAlumnoPorId(Long id) {
        clientCurso.eliminarCursoAlumnoPorId(id);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        super.deleteById(id);
        this.eliminarCursoAlumnoPorId(id);
    }

}