package br.com.doux.doux_projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.doux.doux_projeto.entity.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {

}
