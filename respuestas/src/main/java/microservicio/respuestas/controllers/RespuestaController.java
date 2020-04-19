package microservicio.respuestas.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import microservicio.respuestas.models.entity.Respuesta;
import microservicio.respuestas.services.RespuestaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class RespuestaController {

    @Autowired
    private RespuestaService service;

    // @PostMapping
    // public ResponseEntity<?> crear(@RequestBody Iterable<Respuesta> respuestas) {

    // Iterable<Respuesta> respuestasDb = service.saveAll(respuestas);
    // return ResponseEntity.status(HttpStatus.CREATED).body(respuestasDb);
    // }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Iterable<Respuesta> respuestas) {
        respuestas = ((List<Respuesta>) respuestas).stream().map(r -> {
            r.setAlumnoId(r.getAlumno().getId());
            return r;
        }).collect(Collectors.toList());
        Iterable<Respuesta> respuestasDb = service.saveAll(respuestas);
        return ResponseEntity.status(HttpStatus.CREATED).body(respuestasDb);
    }

    @GetMapping("/alumno/{alumnoId}/examen/{examenId}")
    public ResponseEntity<?> obtenerRespuestasPorAlumnoPorExamen(@PathVariable Long alumnoId,
            @PathVariable Long examenId) {

        Iterable<Respuesta> respuestas = service.findRespuestaByAlumnoByExamen(alumnoId, examenId);
        return ResponseEntity.ok(respuestas);
    }

    @GetMapping("/alumno/{alumnoId}/examenes-respondidos")
    public ResponseEntity<?> obtenerExamenesIdsConRespuestasAlumno(@PathVariable Long alumnoId) {

        Iterable<Long> examenesId = service.findExamenesIdsConRespuestasByAlumno(alumnoId);
        return ResponseEntity.ok(examenesId);
    }

}