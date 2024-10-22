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
import br.com.doux.doux_projeto.entity.Produtos;
import br.com.doux.doux_projeto.service.ProdutosService;


@RequestMapping("/produtos")
@RestController
public class ProdutosController {

    @Autowired
    private ProdutosService produtosService;

     @PostMapping("/")
     List<Produtos> create(@RequestBody Produtos produtos){
        return this.produtosService.create(produtos);
     }

     @GetMapping("/")
     List <Produtos> list(){
        return this.produtosService.list();
     }

     @GetMapping("/{id}")
     public Produtos geProdutosById(@PathVariable("id") Long id){
        return produtosService.findById(id);
     }

     @PutMapping("{id}")
     public Produtos update(@PathVariable("id") Long id, @RequestBody Produtos produtos){
        return this.produtosService.update(id, produtos);
     }

    @DeleteMapping("{id}")
    List<Produtos> delete(@PathVariable("id") Long id){
        return this.produtosService.delete(id);
    }

}