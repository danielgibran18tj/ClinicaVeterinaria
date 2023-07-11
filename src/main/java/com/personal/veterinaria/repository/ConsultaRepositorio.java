package com.personal.veterinaria.repository;

import com.personal.veterinaria.entity.Consulta;
import com.personal.veterinaria.entity.MascotaEmpleadoId;
import org.springframework.data.repository.ListCrudRepository;

public interface ConsultaRepositorio extends ListCrudRepository<Consulta, MascotaEmpleadoId> {
}
