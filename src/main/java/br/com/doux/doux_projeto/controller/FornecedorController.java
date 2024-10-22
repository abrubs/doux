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

import br.com.doux.doux_projeto.entity.Fornecedor;
import br.com.doux.doux_projeto.service.FornecedorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

   @Autowired
    private FornecedorService fornecedorService;

   
    @PostMapping("/")
    List<Fornecedor> create(@Valid @RequestBody Fornecedor fornecedor){
       return this.fornecedorService.create(fornecedor);
    }

    @GetMapping("/")
    List<Fornecedor> list(){
       return this.fornecedorService.list();
    }

   @GetMapping("/{id}")
    public Fornecedor getFornecedorById(@PathVariable("id") Long id){
      return fornecedorService.findById(id);
    }

    @PutMapping("{id}")
    public Fornecedor update(@PathVariable("id") Long id, @RequestBody Fornecedor fornecedor){
       return this.fornecedorService.update(id, fornecedor);
    }
    
    @DeleteMapping("{id}")
    List<Fornecedor> delete(@PathVariable("id") Long id){
       return this.fornecedorService.delete(id);
    }
}
