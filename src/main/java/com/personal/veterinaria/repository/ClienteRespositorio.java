package com.personal.veterinaria.repository;

import com.personal.veterinaria.entity.Cliente;
import org.springframework.data.repository.ListCrudRepository;

public interface ClienteRespositorio extends ListCrudRepository<Cliente , Integer> {
}
