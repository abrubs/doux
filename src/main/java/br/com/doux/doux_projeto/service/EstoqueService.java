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
        // Salva o novo estoque
        estoqueRepository.save(estoque);

        // Após salvar, preenche o objeto produto do estoque criado
        Produtos produto = produtoRepository.findById(estoque.getIdProduto()).orElse(null);
        estoque.setProduto(produto);

        // Retorna a lista de todos os estoques, com o produto preenchido
        return list();
    }


    public List<Estoque> list() {
        // Busca todos os estoques
        List<Estoque> estoques = estoqueRepository.findAll();

        // Para cada estoque, buscar o produto com base no idProduto e preencher os detalhes do produto
        estoques.forEach(estoque -> {
            Produtos produto = produtoRepository.findById(estoque.getIdProduto())
                    .orElse(null); // Use null caso o produto não seja encontrado

            // Aqui você pode associar as informações do Produto ao estoque
            estoque.setProduto(produto); // Se o produto não for encontrado, será null
        });

        return estoques;
    }

    public Estoque findById(Long id) {
        Optional<Estoque> estoqueOptional = estoqueRepository.findById(id);

        if (estoqueOptional.isPresent()) {
            Estoque estoque = estoqueOptional.get();
            // Buscar o produto pelo ID do produto
            Produtos produto = produtoRepository.findById(estoque.getIdProduto()).orElse(null);
            estoque.setProduto(produto); // Setar o produto encontrado no estoque
            return estoque; // Retornar o estoque com o produto preenchido
        }

        return null; // Retornar null ou lançar uma exceção se o estoque não for encontrado
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

