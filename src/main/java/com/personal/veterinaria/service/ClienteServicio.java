package com.personal.veterinaria.service;

import com.personal.veterinaria.entity.Cliente;
import com.personal.veterinaria.entity.Empleado;
import com.personal.veterinaria.repository.ClienteRespositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicio {
    private final ClienteRespositorio clienteRespositorio;

    @Autowired
    public ClienteServicio(ClienteRespositorio clienteRespositorio) {
        this.clienteRespositorio = clienteRespositorio;
    }

    public List<Cliente> getAll(){
        return (List<Cliente>) this.clienteRespositorio.findAll();
    }

    public Cliente getId(int idCliente){
        return this.clienteRespositorio.findById(idCliente).orElse(null);
    }

    public Cliente save(Cliente cliente){
        return this.clienteRespositorio.save(cliente);
    }

    public boolean exists(int idCliente){
        return this.clienteRespositorio.existsById(idCliente);
    }

    public void delete(int id){
        this.clienteRespositorio.deleteById(id);
    }
}
