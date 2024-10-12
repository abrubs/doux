package br.com.doux.doux_projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.doux.doux_projeto.entity.Produtos;
import br.com.doux.doux_projeto.repository.ProdutosRepository;

@Service
public class ProdutosService {

    @Autowired
    private ProdutosRepository produtosRepository;

    public List<Produtos> create(Produtos produtos){
        produtosRepository.save(produtos);
        return list();
    }

    public List<Produtos> list(){
       Sort sort = Sort.by("PrioridadeProduto").descending().and(
           Sort.by("NomeProduto").ascending());
       return produtosRepository.findAll(sort);
    }

    public List<Produtos> update(Produtos produtos){
        produtosRepository.save(produtos);
        return list();
    }

    public List<Produtos> delete(Long id){
        produtosRepository.deleteById(id);
        return list();
    }
}    
    

