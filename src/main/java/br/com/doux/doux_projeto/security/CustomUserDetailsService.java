package br.com.doux.doux_projeto.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.doux.doux_projeto.entity.Funcionarios;
import br.com.doux.doux_projeto.repository.FuncionariosRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private FuncionariosRepository repository;

    @Override
    public UserDetails loadUserByUsername(String NomeFuncionario) throws UsernameNotFoundException {
     
   Funcionarios funcionario = this.repository.findByEmailFuncionario(NomeFuncionario).orElseThrow(() -> new UsernameNotFoundException("Funcionário não encontrado"));
   return new org.springframework.security.core.userdetails.User(funcionario.getEmailFuncionario(), funcionario.getSenhaFuncionario(), new ArrayList<>());
    }
}