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

import br.com.doux.doux_projeto.entity.Produtos;
import br.com.doux.doux_projeto.service.ProdutosService;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosService produtosService;

     
    @PostMapping
    List<Produtos> create(@RequestBody Produtos produtos){
      return produtosService.create(produtos);
    }

    @GetMapping
    List<Produtos> list(){
      return produtosService.list();
    }

    @PutMapping
    List<Produtos> update(@RequestBody Produtos produtos){
      return produtosService.update(produtos);
    }

    @DeleteMapping("{id}")
    List<Produtos> delete(@PathVariable("id") Long id){
      return produtosService.delete(id);
    }
}
