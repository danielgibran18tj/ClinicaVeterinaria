package com.personal.veterinaria.web.controller;

import com.personal.veterinaria.entity.Cliente;
import com.personal.veterinaria.service.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    private final ClienteServicio clienteServicio;

    @Autowired
    public ClienteController(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<Cliente> get(@PathVariable int idCliente){
        System.out.println("hasta aqui vamos bien");
        return ResponseEntity.ok(this.clienteServicio.get(idCliente));
    }

}
