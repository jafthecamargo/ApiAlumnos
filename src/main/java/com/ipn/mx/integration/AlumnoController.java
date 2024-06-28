package com.ipn.mx.integration;

import com.ipn.mx.domain.entity.Alumno;
import com.ipn.mx.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//localhost:8080/api/alumnos
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AlumnoController {
    @Autowired
    AlumnoService service;

    @GetMapping("/alumnos")
    public List<Alumno> readAll() {
        return service.findAll();
    }

    @GetMapping("/alumnos/{id}")
    public Alumno read(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/alumnos")
    public Alumno create(@RequestBody Alumno alumno) {
        return service.save(alumno);
    }

    @PutMapping("/alumnos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Alumno update(@PathVariable Long id, @RequestBody Alumno nuevoAlumno) {
        Alumno alumnoExistente = service.findById(id);
        if (alumnoExistente != null) {
            alumnoExistente.setNombreAlumno(nuevoAlumno.getNombreAlumno());
            alumnoExistente.setPaternoAlumno(nuevoAlumno.getPaternoAlumno());
            alumnoExistente.setMaternoAlumno(nuevoAlumno.getMaternoAlumno());
            alumnoExistente.setCorreoAlumno(nuevoAlumno.getCorreoAlumno());
            return service.save(alumnoExistente);
        } else {
            throw new RuntimeException("No se encontró el alumno con el ID: " + id);
        }
    }

    @DeleteMapping("/alumnos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
