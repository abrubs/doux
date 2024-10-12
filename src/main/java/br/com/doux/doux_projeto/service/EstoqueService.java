package br.com.doux.doux_projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.doux.doux_projeto.entity.Estoque;
import br.com.doux.doux_projeto.repository.EstoqueRepository;

@Service
public class EstoqueService {
    @Autowired
    private EstoqueRepository estoqueRepository;

    
    public List<Estoque> create(Estoque estoque) {
        estoqueRepository.save(estoque);
        return list();
    }

    public List<Estoque> list() {
       Sort sort = Sort.by("PrioridadeEstoque").descending().and(
            Sort.by("IdEstoque").ascending());
             return estoqueRepository.findAll(sort);
    }

    public List<Estoque> update(Estoque estoque) {
        estoqueRepository.save(estoque);
        return list();
    }

    public List<Estoque> delete(Long id) {
        estoqueRepository.deleteById(id);
        return list();
    }
}
