package com.personal.veterinaria.service;

import com.personal.veterinaria.entity.Cliente;
import com.personal.veterinaria.repository.ClienteRespositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServicio {
    private final ClienteRespositorio clienteRespositorio;

    @Autowired
    public ClienteServicio(ClienteRespositorio clienteRespositorio) {
        this.clienteRespositorio = clienteRespositorio;
    }

    public Cliente get(int idCliente){
        return this.clienteRespositorio.findById(idCliente).orElse(null);
    }
}
