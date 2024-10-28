package br.com.secutityFornecedor;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.doux.doux_projeto.entity.Fornecedor;
import br.com.doux.doux_projeto.repository.FornecedorRepository;



@Component
public class CustomFornecedorDetailsService implements UserDetailsService{

    @Autowired
    private FornecedorRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
   Fornecedor fornecedor = this.repository.findByEmailFornecedor(username).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
      return new org.springframework.security.core.userdetails.User(fornecedor.getEmailFornecedor(), fornecedor.getSenhaFornecedor(), new ArrayList<>());
 }
}
