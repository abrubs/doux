package br.com.doux.doux_projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.doux.doux_projeto.entity.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long>{
    
}
