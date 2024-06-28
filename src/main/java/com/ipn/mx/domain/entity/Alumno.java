package com.ipn.mx.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Alumno")
public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlumno;

    @NotBlank(message = "El nombre del alumno no puede estar vacío")
    @Size(min = 4, max = 150, message = "El nombre del alumno debe tener entre 4 y 150 caracteres")
    @Column(name = "nombreAlumno", length = 50, nullable = false)
    private String nombreAlumno;

    @NotBlank(message = "El apellido paterno del alumno no puede estar vacío")
    @Size(min = 4, max = 150, message = "El apellido paterno del alumno debe tener entre 4 y 150 caracteres")
    @Column(name = "paternoAlumno", length = 50, nullable = false)
    private String paternoAlumno;

    @NotBlank(message = "El apellido materno del alumno no puede estar vacío")
    @Size(min = 4, max = 150, message = "El apellido materno del alumno debe tener entre 4 y 150 caracteres")
    @Column(name = "maternoAlumno", length = 50, nullable = false)
    private String maternoAlumno;

    @NotBlank(message = "El correo del alumno no puede estar vacío")
    @Size(min = 4, max = 150, message = "El correo del alumno debe tener entre 4 y 150 caracteres")
    @Column(name = "correoAlumno", length = 50, nullable = false)
    private String correoAlumno;
}
