package microservicio.cursos.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import microservicio.commons.controllers.CommonController;
import microservicio.cursos.models.entity.Curso;
import microservicio.cursos.services.CursoService;

/**
 * CursoController
 */
@RestController
public class CursoController extends CommonController<Curso, CursoService> {

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Curso curso, @PathVariable Long id) {
        Optional<Curso> o = this.service.findById(id);
        if (!o.isPresent())
            return ResponseEntity.notFound().build();

        Curso c = o.get();
        c.setNombre(curso.getNombre());
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(c));

    }
}