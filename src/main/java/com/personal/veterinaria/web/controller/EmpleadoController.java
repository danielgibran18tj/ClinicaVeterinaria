package com.personal.veterinaria.web.controller;

import com.personal.veterinaria.entity.Empleado;
import com.personal.veterinaria.service.EmpleadoServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Operation(summary = "Obtener lista de empleados")
    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista disponible"),
            @ApiResponse(responseCode = "404", description = "Lista no encontrada")
    })
    public ResponseEntity<List<Empleado>> getAll(){
        return new ResponseEntity<>(empleadoServicio.getAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener lista de empleados por ID")
    @GetMapping("/{idEmpleado}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario disponible"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    public ResponseEntity<Empleado> get(@PathVariable int idEmpleado){
        return ResponseEntity.ok(this.empleadoServicio.get(idEmpleado));
    }

    @Operation(summary = "Ingresar un nuevo empleado")
    @PostMapping
    public ResponseEntity<Empleado> agg(@RequestBody Empleado empleado){
        if (empleado.getIdEmpleado()== null || !this.empleadoServicio.exists(empleado.getIdEmpleado())){
            return ResponseEntity.ok(this.empleadoServicio.save(empleado));
        }
        return ResponseEntity.badRequest().build();
    }

    @Operation(summary = "Actualizar un nuevo empleado")
    @PutMapping
    public ResponseEntity<Empleado> update(@RequestBody Empleado empleado){
        if (empleado.getIdEmpleado()!= null && this.empleadoServicio.exists(empleado.getIdEmpleado())){
            return ResponseEntity.ok(this.empleadoServicio.save(empleado));
        }
        return ResponseEntity.badRequest().build();    }

    @Operation(summary = "Eliminar un nuevo empleado por ID")
    @DeleteMapping("/{idEmpleado}")
    public ResponseEntity<Void> delete(@PathVariable int idEmpleado){
        if (this.empleadoServicio.exists(idEmpleado)){
            this.empleadoServicio.delete(idEmpleado);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
