package br.com.doux.doux_projeto.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import br.com.doux.doux_projeto.entity.Estoque;
import br.com.doux.doux_projeto.exception.ResourceNotFoundException;
import br.com.doux.doux_projeto.repository.EstoqueRepository;
import jakarta.annotation.Resource;

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

    public Estoque findById(Long id) {
       return estoqueRepository.findById(id);
         .orElseThrow(()-> new ResourceNotFoundException("Estoque não encontrado com id" + id));
    

   pubic Estoque update(Long id, Estoque estoque) {
    Estoque existingEstoque = estoqueRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Estoque não encontrado com id" + id));

    existingEstoque.setQuantidadeDisponivel(estoque.getQuantidadeDisponivel());
    existingEstoque.setDataUltimaAtualizacao(estoque.getDataUltimaAtualizacao());
    existingEstoque.setPrioridadeEstoque(estoque.getPrioridadeEstoque());

    return estoqueRepository.save(existingEstoque);
   }

   public List<Estoque> delete(Long id){
    estoqueRepository.deleteById(id);
    return list();
    }
}
