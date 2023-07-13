package com.personal.veterinaria.service;

import com.personal.veterinaria.entity.Cliente;
import com.personal.veterinaria.repository.ClienteRespositorio;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Collection;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

//@ExtendWith(MockitoExtension.class)
//@WebMvcTest(controllers = ClienteServicio.class)
class ClienteServicioTest {

    //@Mock
    private ClienteServicio clienteServicio;

    @BeforeEach
    void setUp() throws Exception{
        ClienteRespositorio clienteRespositorio = Mockito.mock(ClienteRespositorio.class);

        Mockito.when(clienteRespositorio.findById(456709123)).thenReturn(Optional.of(cliente()));
        clienteServicio = new ClienteServicio(clienteRespositorio);
    }

    @Test
    void getId() {
        Cliente cliente = clienteServicio.getId(456709123);
        assertEquals("Cliente 5", cliente.getNombre());
    }

    static Cliente cliente(){
        var cliente = new Cliente();
        cliente.setIdCliente(456709123);
        cliente.setNombre("Cliente 5");
        return cliente;
    }
}