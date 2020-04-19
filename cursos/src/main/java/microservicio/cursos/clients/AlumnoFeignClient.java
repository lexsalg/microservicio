package microservicio.cursos.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import microservicio.commonsalumnos.models.entity.Alumno;

@FeignClient(name = "microservicio-alumnos")
public interface AlumnoFeignClient {

    @GetMapping("/alumnos-por-curso")
    public List<Alumno> obtenerAlumnosPorCurso(@RequestParam("ids") List<Long> ids);

}