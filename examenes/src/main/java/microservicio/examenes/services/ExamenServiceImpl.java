package microservicio.examenes.services;

import org.springframework.stereotype.Service;

import microservicio.commons.services.CommonServiceImpl;
import microservicio.commonsexamenes.models.entity.Examen;
import microservicio.examenes.models.repository.ExamenRepository;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository> implements ExamenService {

}