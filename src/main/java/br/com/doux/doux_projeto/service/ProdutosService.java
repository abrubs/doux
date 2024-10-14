package br.com.doux.doux_projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.doux.doux_projeto.entity.Produtos;
import br.com.doux.doux_projeto.exception.ResourceNotFoundException;
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

    public Produtos findById(Long id){
        return produtosRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com id"+ id));
        
    }

    public Produtos update(Long id, Produtos produtos){
        Produtos existingProdutos = produtosRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com id"+ id));

        existingProdutos.setCategoriaProduto(produtos.getCategoriaProduto());
        existingProdutos.setNomeProduto(produtos.getNomeProduto());
        existingProdutos.setFornecedor(produtos.getFornecedor());
        existingProdutos.setMarca(produtos.getMarca());
        existingProdutos.setEstoqueAtual(produtos.getEstoqueAtual());
        existingProdutos.setDescricaoProduto(produtos.getDescricaoProduto());
        existingProdutos.setPreco(produtos.getPreco());
        existingProdutos.setPrioridadeProduto(produtos.getPrioridadeProduto());

        return produtosRepository.save(existingProdutos);
    }


    public List<Produtos> delete(Long id){
        produtosRepository.deleteById(id);
        return list();
    }
}    
    

