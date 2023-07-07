package com.personal.veterinaria.web.controller;

import com.personal.veterinaria.entity.Empleado;
import com.personal.veterinaria.service.EmpleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {
    private final EmpleadoServicio empleadoServicio;

    @Autowired
    public EmpleadoController(EmpleadoServicio empleadoServicio) {
        this.empleadoServicio = empleadoServicio;
    }

    @GetMapping
    public ResponseEntity<List<Empleado>> getAll(){
        return ResponseEntity.ok(this.empleadoServicio.getAll());
    }

    @PostMapping
    public ResponseEntity<Empleado> agg(@RequestBody Empleado empleado){
        if (empleado.getIdEmpleado()== null || !this.empleadoServicio.exists(empleado.getIdEmpleado())){
            return ResponseEntity.ok(this.empleadoServicio.save(empleado));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Empleado> update(@RequestBody Empleado empleado){
        if (empleado.getIdEmpleado()!= null && this.empleadoServicio.exists(empleado.getIdEmpleado())){
            return ResponseEntity.ok(this.empleadoServicio.save(empleado));
        }
        return ResponseEntity.badRequest().build();    }
}
