package br.com.doux.doux_projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.doux.doux_projeto.entity.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
    
}
