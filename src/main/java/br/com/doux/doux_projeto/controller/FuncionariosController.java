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

import br.com.doux.doux_projeto.entity.Funcionarios;
import br.com.doux.doux_projeto.service.FuncionariosService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionariosController {

    @Autowired 
    private FuncionariosService funcionariosService;

    @PostMapping
    List<Funcionarios> create(@RequestBody Funcionarios funcionarios){
      return funcionariosService.create(funcionarios);
    }

    @GetMapping
    List<Funcionarios> list(){
      return funcionariosService.list();
    }

    @PutMapping
    List<Funcionarios> update(@RequestBody Funcionarios funcionarios){
      return funcionariosService.update(funcionarios);
    }
    
    @DeleteMapping("{id}")
    List<Funcionarios> delete(@PathVariable("id") Long id){
      return funcionariosService.delete(id);
    }
}
