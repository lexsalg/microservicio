package microservicio.examenes.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import microservicio.commonsexamenes.models.entity.Examen;

/**
 * ExamenRepository
 */
public interface ExamenRepository extends PagingAndSortingRepository<Examen, Long> {

    @Query("SELECT e FROM Examen e WHERE e.nombre like %?1%")
    public List<Examen> findByNombre(String term);
}