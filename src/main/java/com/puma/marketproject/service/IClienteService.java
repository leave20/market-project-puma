package com.puma.marketproject.service;

import com.puma.marketproject.model.Cliente;

import java.util.List;

public interface IClienteService {

    public List<Cliente> findAll();

    //CREAR METODO PARA AGREGAR
    public void save(Cliente cliente);

    //METODO 3: EDITAR CLIENTE
    public Cliente editarCliente(Long id);

    //METODO 4: ELIMINAR CLIENTE
    public void eliminarCliente(Long id);

}
