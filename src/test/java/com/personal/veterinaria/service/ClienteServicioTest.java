package com.personal.veterinaria.service;

import com.personal.veterinaria.entity.Cliente;
import com.personal.veterinaria.repository.ClienteRespositorio;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Collection;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

//@ExtendWith(MockitoExtension.class)
//@WebMvcTest(controllers = ClienteServicio.class)
public class ClienteServicioTest {

    //@Mock
    private ClienteServicio clienteServicio;

    @Before
    public void setUp() throws Exception{
        ClienteRespositorio clienteRespositorio = Mockito.mock(ClienteRespositorio.class);

        Mockito.when(clienteRespositorio.findById(456709123)).thenReturn(Optional.of(cliente()));
        ClienteServicio clienteServicio = new ClienteServicio(clienteRespositorio);
    }

    @Test
    public void getId() {
        Collection<Cliente> clientes = (Collection<Cliente>) clienteServicio.getId(456709123);
        assertEquals("Cliente 5", clienteServicio.getId(456709123).getNombre());
    }

    private Cliente cliente(){
        var cliente = new Cliente();
        cliente.setIdCliente(456709123);
        cliente.setNombre("Cliente 5");
        return cliente;
    }
}