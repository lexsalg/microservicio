package microservicio.alumnos.controlllers;

import java.io.IOException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import microservicio.alumnos.services.AlumnoService;
import microservicio.commons.controllers.CommonController;
import microservicio.commonsalumnos.models.entity.Alumno;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * AlumnoController
 */
@RestController
public class AlumnoController extends CommonController<Alumno, AlumnoService> {

    @GetMapping("/uploads/img/{id}")
    public ResponseEntity<?> verFoto(@PathVariable Long id) {
        Optional<Alumno> o = service.findById(id);

        if (o.isEmpty() || o.get().getFoto() == null)
            return ResponseEntity.notFound().build();

        Resource imagen = new ByteArrayResource(o.get().getFoto());

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imagen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @Valid @RequestBody Alumno alumno, BindingResult result) {

        if (result.hasErrors())
            return this.validar(result);

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

    @GetMapping("/filtrar/{value}")
    public ResponseEntity<?> filtrar(@PathVariable String value) {
        return ResponseEntity.ok(service.findByNombreOrApellido(value));
    }

    @PostMapping("/crear-con-foto")
    public ResponseEntity<?> crearConFoto(@Valid Alumno alumno, BindingResult result,
            @RequestParam MultipartFile archivo) throws IOException {

        if (!archivo.isEmpty())
            alumno.setFoto(archivo.getBytes());

        return super.crear(alumno, result);
    }

    @PutMapping("/editar-con-foto/{id}")
    public ResponseEntity<?> editarConFoto(@PathVariable Long id, @Valid Alumno alumno, BindingResult result,
            @RequestParam MultipartFile archivo) throws IOException {

        if (result.hasErrors())
            return this.validar(result);

        Optional<Alumno> o = service.findById(id);
        if (o.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Alumno a = o.get();

        a.setNombre(alumno.getNombre());
        a.setApellido(alumno.getApellido());
        a.setEmail(alumno.getEmail());

        if (!archivo.isEmpty())
            a.setFoto(archivo.getBytes());

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(a));
    }

}