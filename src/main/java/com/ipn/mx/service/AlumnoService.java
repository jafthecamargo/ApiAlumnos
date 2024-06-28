package com.ipn.mx.service;

import com.ipn.mx.domain.entity.Alumno;

import java.util.List;

public interface AlumnoService {
    public List<Alumno> findAll();
    public Alumno findById(Long id);
    public Alumno save(Alumno alumno);
    public void delete(Long id);
}
