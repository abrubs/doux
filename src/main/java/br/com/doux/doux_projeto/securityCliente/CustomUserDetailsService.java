package br.com.doux.doux_projeto.securityCliente;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.doux.doux_projeto.entity.Clientes;
import br.com.doux.doux_projeto.entity.Fornecedor;
import br.com.doux.doux_projeto.repository.ClientesRepository;
import br.com.doux.doux_projeto.repository.FornecedorRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
  
        Clientes cliente = clientesRepository.findByEmailCliente(username).orElse(null);
        if (cliente != null) {
            return new org.springframework.security.core.userdetails.User(cliente.getEmailCliente(), cliente.getSenhaCliente(), new ArrayList<>());
        }

        Fornecedor fornecedor = fornecedorRepository.findByEmailFornecedor(username).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        return new org.springframework.security.core.userdetails.User(fornecedor.getEmailFornecedor(), fornecedor.getSenhaFornecedor(), new ArrayList<>());
    }
}