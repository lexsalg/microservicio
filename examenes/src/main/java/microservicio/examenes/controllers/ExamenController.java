package microservicio.examenes.controllers;

// import java.util.ArrayList;
// import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import microservicio.commons.controllers.CommonController;
import microservicio.commonsexamenes.models.entity.Examen;
// import microservicio.examenes.models.entity.Pregunta;
import microservicio.examenes.services.ExamenService;

@RestController
public class ExamenController extends CommonController<Examen, ExamenService> {

    // @PutMapping("/{id}")
    // public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Examen
    // examen) {

    // Optional<Examen> o = service.findById(id);

    // if (!o.isPresent())
    // return ResponseEntity.notFound().build();

    // Examen examenDb = o.get();
    // examenDb.setNombre(examen.getNombre());

    // List<Pregunta> eliminadas = new ArrayList<>();

    // examenDb.getPreguntas().forEach(pdb -> {
    // if (!examen.getPreguntas().contains(pdb))
    // eliminadas.add(pdb);
    // });

    // // eliminadas.forEach(p -> examenDb.removePregunta(p));
    // eliminadas.forEach(examenDb::removePregunta);

    // examenDb.setPreguntas(examen.getPreguntas());

    // return
    // ResponseEntity.status(HttpStatus.CREATED).body(service.save(examenDb));
    // }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Examen examen) {

        Optional<Examen> o = service.findById(id);

        if (!o.isPresent())
            return ResponseEntity.notFound().build();

        Examen examenDb = o.get();
        examenDb.setNombre(examen.getNombre());

        examenDb.getPreguntas().stream().filter(pdb -> !examen.getPreguntas().contains(pdb))
                .forEach(examenDb::removePregunta);

        examenDb.setPreguntas(examen.getPreguntas());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examenDb));
    }
}