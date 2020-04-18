package microservicio.examenes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import microservicio.commons.services.CommonServiceImpl;
import microservicio.commonsexamenes.models.entity.Asignatura;
import microservicio.commonsexamenes.models.entity.Examen;
import microservicio.examenes.models.repository.AsignaturaRepository;
import microservicio.examenes.models.repository.ExamenRepository;

@Service
@Transactional(readOnly = true)
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository> implements ExamenService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Examen> findByNombre(String term) {

        return repository.findByNombre(term);
    }

    // @Override
    // @Transactional(readOnly = true)
    // public List<Asignatura> findAllAsignaturas() {
    // return (List<Asignatura>) asignaturaRepository.findAll();
    // }
    @Override
    @Transactional(readOnly = true)
    public Iterable<Asignatura> findAllAsignaturas() {
        return asignaturaRepository.findAll();
    }

}