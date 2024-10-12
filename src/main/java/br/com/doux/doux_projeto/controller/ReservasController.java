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

import br.com.doux.doux_projeto.entity.Reservas;
import br.com.doux.doux_projeto.service.ReservasService;

@RestController
@RequestMapping("/reservas")
public class ReservasController {

    @Autowired
    private ReservasService reservasService; 

    @PostMapping
    List<Reservas> create(@RequestBody Reservas reservas){
        return reservasService.create(reservas);
    }

    @GetMapping
    List<Reservas> list(){
        return reservasService.list();
    }

    @PutMapping
    List<Reservas> update(@RequestBody Reservas reservas){
        return reservasService.update(reservas);
    }

    @DeleteMapping("{id}")
    List<Reservas> delete(@PathVariable("id") Long id){
        return reservasService.delete(id);
    }
}
