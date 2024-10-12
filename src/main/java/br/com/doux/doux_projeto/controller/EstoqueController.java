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

import br.com.doux.doux_projeto.entity.Estoque;
import br.com.doux.doux_projeto.service.EstoqueService;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

   

    @PostMapping
    List<Estoque> create(@RequestBody Estoque estoque){
      return estoqueService.create(estoque);
    }

    @GetMapping
    List<Estoque> list (){
      return estoqueService.list();
    }

    @PutMapping
    List<Estoque> update(@RequestBody Estoque estoque){
      return estoqueService.update(estoque);
    }

    @DeleteMapping("{id}")
    List<Estoque> delete(@PathVariable("id") Long id){
      return estoqueService.delete(id); 
    }
}
