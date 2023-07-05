package com.personal.veterinaria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mascota")
@Getter
@Setter
@NoArgsConstructor
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota", nullable = false, length = 15)
    private Integer idMascota;

    @Column(nullable = false, length = 60)
    private String nombre;

    @Column(length = 50)
    private String animal;

    @Column(length = 50)
    private String raza;

    @Column(nullable = false, length = 5)
    private Integer edad;

    // Relación muchos a uno con Cliente
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonIgnore     //ignorando este parametro porque haria un llamado recursivo infinito en mi get de OrderEntity
    private Cliente idCliente;

    // Relación 1 a 1 con Consulta
    @OneToOne(mappedBy = "idMascota")
    private Consulta idConsulta;
}
