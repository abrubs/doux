package br.com.doux.doux_projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.doux.doux_projeto.entity.Estoque;
import br.com.doux.doux_projeto.service.EstoqueService;


@RequestMapping("/estoque")
@RestController
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

   

    @PostMapping("/")
    List<Estoque> create(@RequestBody Estoque estoque){
      return this.estoqueService.create(estoque);
    }

   @GetMapping("/")
   List<Estoque> list(){
    return this.estoqueService.list();
   }

  @GetMapping("/{id}")
  public Estoque getEstoqueById(@PathVariable("id") Long id){
     return estoqueService.findById(id);
   }
    
    
   
    @DeleteMapping("{id}")
    List<Estoque> delete(@PathVariable("id") Long id){
      return this.estoqueService.delete(id); 
    }
}
