package com.personal.veterinaria.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "consulta")
@Getter
@Setter
@NoArgsConstructor
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta", nullable = false,length = 15)
    private Integer idConsulta;

    @Column(nullable = false, length = 60, columnDefinition = "timestamp")
    private String fecha;

    @Column(length = 50)
    private String antecedente;

    // Relación muchos a uno con Empleado
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado idEmpleado;

    // Relación 1 a 1 con Mascota
    @OneToOne
    @JoinColumn(name = "id_mascota")
    private Mascota idMascota;
}