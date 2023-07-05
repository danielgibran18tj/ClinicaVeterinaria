package com.personal.veterinaria.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "empleado")
//@IdClass(EmpleadoClienteId.class)
@Getter
@Setter
@NoArgsConstructor
public class Empleado {
    // Relación 1 a muchos con Consulta
    @Id
    @Column(name = "id_empleado", nullable = false, length = 15)
    private Integer idEmpleado;

    @OneToMany(mappedBy = "empleado")
    private List<Consulta> idConsultaEmpleado;

    @Column(nullable = false, length = 60)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String direccion;

    @Column(name = "numero_celular", nullable = false,length = 50)
    private String numeroCelular;

    @Column(length = 30, nullable = false)
    private String puesto;

    // Relación muchos a uno con Sucursal
    @ManyToOne
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")
    private Sucursal idSucursal;

}
