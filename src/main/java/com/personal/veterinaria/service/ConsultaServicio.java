package com.personal.veterinaria.service;

import com.personal.veterinaria.entity.Consulta;
import com.personal.veterinaria.repository.ConsultaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaServicio {
    private final ConsultaRepositorio consultaRepositorio;

    @Autowired
    public ConsultaServicio(ConsultaRepositorio consultaRepositorio) {
        this.consultaRepositorio = consultaRepositorio;
    }

    public List<Consulta> getAll(){
        List<Consulta> consultas =  this.consultaRepositorio.findAll();
        return consultas;
    }

}
