package br.com.doux.doux_projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.doux.doux_projeto.entity.Estoque;
import br.com.doux.doux_projeto.entity.Produtos;
import br.com.doux.doux_projeto.exception.ResourceNotFoundException;
import br.com.doux.doux_projeto.repository.EstoqueRepository;
import br.com.doux.doux_projeto.repository.ProdutosRepository;


@Service
public class EstoqueService {
    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private ProdutosRepository produtoRepository;

    public List<Estoque> create(Estoque estoque) {
        
        estoqueRepository.save(estoque);

        Produtos produto = produtoRepository.findById(estoque.getIdProduto()).orElse(null);
        estoque.setProduto(produto);

        return list();
    }


    public List<Estoque> list() {
        List<Estoque> estoques = estoqueRepository.findAll();
        estoques.forEach(estoque -> {
            Produtos produto = produtoRepository.findById(estoque.getIdProduto())
                    .orElse(null); 
            estoque.setProduto(produto); 
        });

        return estoques;
    }

    public Estoque findById(Long id) {
        Optional<Estoque> estoqueOptional = estoqueRepository.findById(id);

        if (estoqueOptional.isPresent()) {
            Estoque estoque = estoqueOptional.get();
            Produtos produto = produtoRepository.findById(estoque.getIdProduto()).orElse(null);
            estoque.setProduto(produto); 
            return estoque; 
        }

        return null; 
    }


    public List<Estoque> update(Estoque estoque) {
        estoqueRepository.save(estoque);
        return list();
    }


    public List<Estoque> delete(Long id) {
        estoqueRepository.deleteById(id);
        return list();
    }
   public Estoque update(Long id, Estoque estoque) {
    Estoque existingEstoque = estoqueRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Estoque não encontrado com id" + id));

    existingEstoque.setQuantidadeDisponivel(estoque.getQuantidadeDisponivel());
    existingEstoque.setDataUltimaAtualizacao(estoque.getDataUltimaAtualizacao());
    existingEstoque.setPrioridadeEstoque(estoque.getPrioridadeEstoque());

    return estoqueRepository.save(existingEstoque);
   }

    }

