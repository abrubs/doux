package br.com.doux.doux_projeto.securityCliente;

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
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

  

    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = recoverToken(request);
        
       
        var loginCliente = tokenService.validateToken(token);
        if (loginCliente != null) {
            Clientes cliente = clientesRepository.findByEmailCliente(loginCliente)
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
            var authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
            var authentication = new UsernamePasswordAuthenticationToken(cliente, null, authorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            var loginFornecedor = tokenService.validateToken(token);
            if (loginFornecedor != null) {
                Fornecedor fornecedor = fornecedorRepository.findByEmailFornecedor(loginFornecedor)
                        .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
                var authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
                var authentication = new UsernamePasswordAuthenticationToken(fornecedor, null, authorities);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }
}