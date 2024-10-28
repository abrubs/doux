package br.com.doux.doux_projeto.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.doux.doux_projeto.entity.Fornecedor;


public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{ 

      Optional<Fornecedor> findByEmailFornecedor(String emailFornecedor);

}
    

