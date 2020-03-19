
package microservicio.alumnos.controlllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import microservicio.alumnos.models.entity.Alumno;
import microservicio.alumnos.services.AlumnoService;
import microservicio.commons.controllers.CommonController;

/**
 * AlumnoController
 */
@RestController
public class AlumnoController extends CommonController<Alumno, AlumnoService> {

    @PostMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id) {
        Optional<Alumno> o = service.findById(id);
        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Alumno a = o.get();

        a.setNombre(alumno.getNombre());
        a.setApellido(alumno.getApellido());
        a.setEmail(alumno.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(a));
    }

}