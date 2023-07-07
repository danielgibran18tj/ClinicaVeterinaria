package com.personal.veterinaria.repository;

import com.personal.veterinaria.entity.Empleado;
import org.springframework.data.repository.ListCrudRepository;

public interface EmpleadoRepository extends ListCrudRepository<Empleado, Integer> {
}
