package br.com.doux.doux_projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.doux.doux_projeto.entity.Fornecedor;
import br.com.doux.doux_projeto.repository.FornecedorRepository;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Fornecedor> create(Fornecedor fornecedor){
        fornecedorRepository.save(fornecedor);
        return list();
    }

    public List<Fornecedor> list(){
        Sort sort = Sort.by("PrioridadeFornecedor").descending().and(
        Sort.by("Nomefornecedor").ascending());
        return fornecedorRepository.findAll(sort);
    }

    public List<Fornecedor> update(Fornecedor fornecedor){
        fornecedorRepository.save(fornecedor);
        return list();
    }

    public List<Fornecedor> delete(Long id){
        fornecedorRepository.deleteById(id);
        return list();
    }
}
