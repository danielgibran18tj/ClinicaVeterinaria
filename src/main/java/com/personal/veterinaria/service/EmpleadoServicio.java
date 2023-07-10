package com.personal.veterinaria.service;

import com.personal.veterinaria.entity.Cliente;
import com.personal.veterinaria.entity.Empleado;
import com.personal.veterinaria.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServicio {
    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoServicio(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<Empleado> getAll() {
        List<Empleado> empleados = this.empleadoRepository.findAll();
        return empleados;
    }

    public Empleado get(int idEmpleado){
        return this.empleadoRepository.findById(idEmpleado).orElse(null);
    }

    public Empleado save(Empleado empleado){
        return this.empleadoRepository.save(empleado);
    }

    public boolean exists(int idEmpleado){
        return this.empleadoRepository.existsById(idEmpleado);
    }

    public void delete(int id){
        this.empleadoRepository.deleteById(id);
    }
}
