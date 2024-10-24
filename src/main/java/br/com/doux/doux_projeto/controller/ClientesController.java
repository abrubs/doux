package br.com.doux.doux_projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.doux.doux_projeto.entity.Clientes;
import br.com.doux.doux_projeto.service.ClientesService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")

public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    

    @PostMapping("/")
     List<Clientes> create(@Valid @RequestBody Clientes clientes) {
     return this.clientesService.create(clientes);
    }
    
    @GetMapping("/")
    List<Clientes> list() {
        return this.clientesService.list();
    }

    @GetMapping("/{id}")
    public Clientes getClienteById(@PathVariable("id") Long id) {
        return clientesService.findById(id);
    }

    @PutMapping("{id}")
    public Clientes update(@PathVariable("id") Long id, @RequestBody Clientes clientes) {
        return this.clientesService.update(id, clientes);
    }
    
    @DeleteMapping("{id}")
    List<Clientes> delete(@PathVariable("id") Long id) {
        return this.clientesService.delete(id);
    }
}