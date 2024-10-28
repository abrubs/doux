package br.com.doux.doux_projeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.doux.doux_projeto.entity.Funcionarios;

public interface FuncionariosRepository extends JpaRepository<Funcionarios, Long> {
    
    Optional<Funcionarios> findByEmailFuncionario(String emailFuncionario);
}
