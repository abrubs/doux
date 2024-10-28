package br.com.secutityFornecedor;


import java.io.IOException;
import java.util.Collections;

import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.doux.doux_projeto.entity.Clientes;
import br.com.doux.doux_projeto.entity.Fornecedor;
import br.com.doux.doux_projeto.repository.ClientesRepository;
import br.com.doux.doux_projeto.repository.FornecedorRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilterFornecedor extends OncePerRequestFilter {

    @Autowired
    TokenServiceFornecedor tokenService;

    @Autowired
    FornecedorRepository fornecedorRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException{
    var token = this.recoverToken(request);
    var login = tokenService.validateToken(token);

    if(login != null){
        Fornecedor fornecedor = fornecedorRepository.findByEmailFornecedor(login).orElseThrow(() -> new RuntimeException("User não encontrado"));
        var authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
        var authentication = new UsernamePasswordAuthenticationToken(fornecedor, null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
       filterChain.doFilter(request, response);
    }
    private String recoverToken(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }
}