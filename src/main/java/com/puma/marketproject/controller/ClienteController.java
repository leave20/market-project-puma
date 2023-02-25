package com.puma.marketproject.controller;

import com.puma.marketproject.model.Cliente;
import com.puma.marketproject.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public List<Cliente> listar() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> editar(@PathVariable("id") Long id) {
        Cliente cliente = clienteService.editarCliente(id);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping("/guardar")
    public ResponseEntity<Cliente> guardar(@RequestBody Cliente cliente) {
        clienteService.save(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Cliente> actualizar(@RequestBody Cliente cliente, @PathVariable("id") Long id) {
        Cliente clienteActual = clienteService.editarCliente(id);
        clienteActual.setNombre(cliente.getNombre());
        clienteActual.setApellido(cliente.getApellido());
        clienteActual.setDni(cliente.getDni());
        clienteService.save(clienteActual);
        return ResponseEntity.ok(clienteActual);
    }


    //no aplicar en caso real
    //en su lugar reemplazar por un cambio de estado
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable("id") Long id) {
        clienteService.eliminarCliente(id);
        return ResponseEntity.ok().build();
    }


}
