package com.puma.marketproject.controller;

import com.puma.marketproject.model.Cliente;
import com.puma.marketproject.repository.ClienteRepository;
import com.puma.marketproject.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final IClienteService clienteService;

    @Autowired
    public ClienteController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/listar")
    public List<Cliente> listar(){
        return clienteService.findAll();
    }
}
