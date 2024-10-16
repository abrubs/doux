package br.com.doux.doux_projeto.controller;

import java.util.List;

import br.com.doux.doux_projeto.entity.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Estoque>> list() {
        List<Estoque> estoques = estoqueService.list();
        return ResponseEntity.ok(estoques);  // Retorna a lista de estoques com os produtos
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estoque> getEstoqueById(@PathVariable("id") Long id) {
        Estoque estoque = estoqueService.findById(id);

        if (estoque != null) {
            return ResponseEntity.ok(estoque); // Retorna 200 OK com o estoque encontrado
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found se o estoque não for encontrado
        }
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
