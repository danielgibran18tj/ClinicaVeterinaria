package com.personal.veterinaria.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
public class Cliente {
    @Id
    @Column(name = "id_cliente", nullable = false, length = 15)
    private Integer idCliente;

    @Column(nullable = false, length = 60)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String direccion;

    @Column(name = "numero_celular", nullable = false,length = 50)
    private String numeroCelular;

    @Column(length = 50, unique = true)
    private String email;
}
