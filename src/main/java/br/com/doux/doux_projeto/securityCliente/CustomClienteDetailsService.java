package br.com.doux.doux_projeto.securityCliente;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.doux.doux_projeto.entity.Clientes;
import br.com.doux.doux_projeto.repository.ClientesRepository;



@Component
public class CustomClienteDetailsService implements UserDetailsService{

    @Autowired
    private ClientesRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
    Clientes cliente = this.repository.findByEmailCliente(username).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
      return new org.springframework.security.core.userdetails.User(cliente.getEmailCliente(), cliente.getSenhaCliente(), new ArrayList<>());
 }
}