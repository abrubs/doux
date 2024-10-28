package br.com.doux.doux_projeto.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.doux.doux_projeto.dtoCliente.LoginRequestDTO;
import br.com.doux.doux_projeto.dtoCliente.RegisterRequestDTO;
import br.com.doux.doux_projeto.dtoCliente.ResponseDTO;
import br.com.doux.doux_projeto.entity.Clientes;
import br.com.doux.doux_projeto.entity.Fornecedor;
import br.com.doux.doux_projeto.repository.ClientesRepository;
import br.com.doux.doux_projeto.repository.FornecedorRepository;
import br.com.doux.doux_projeto.securityCliente.TokenService;
import br.com.doux.dtoFornecedor.LoginRequestFornecedorDTO;
import br.com.doux.dtoFornecedor.RegisterRequestFornecedorDTO;
import br.com.doux.dtoFornecedor.ResponseFornecedorDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final ClientesRepository clientesRepository;
    private final FornecedorRepository fornecedorRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequestDTO body) {
        Clientes cliente = clientesRepository.findByEmailCliente(body.emailCliente())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        
        if (passwordEncoder.matches(body.senhaCliente(), cliente.getSenhaCliente())) {
            String token = tokenService.generateToken(cliente);
            return ResponseEntity.ok(new ResponseDTO(cliente.getNomeCliente(), token));
        }
        return ResponseEntity.badRequest().body("Usuário não encontrado");
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegisterRequestDTO body) {
        Optional<Clientes> cliente = clientesRepository.findByEmailCliente(body.emailCliente());

        if (cliente.isEmpty()) {
            Clientes newCliente = new Clientes();
            newCliente.setSenhaCliente(passwordEncoder.encode(body.senhaCliente()));
            newCliente.setEmailCliente(body.emailCliente());
            newCliente.setNomeCliente(body.nomeCliente());
            clientesRepository.save(newCliente);

            String token = tokenService.generateToken(newCliente);
            return ResponseEntity.ok(new ResponseDTO(newCliente.getNomeCliente(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/login-fornecedor")
    public ResponseEntity<Object> loginFornecedor(@RequestBody LoginRequestFornecedorDTO body) {
        Fornecedor fornecedor = fornecedorRepository.findByEmailFornecedor(body.emailFornecedor())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        
        if (passwordEncoder.matches(body.senhaFornecedor(), fornecedor.getSenhaFornecedor())) {
            String token = tokenService.generateTokenFornecedor(fornecedor);
            return ResponseEntity.ok(new ResponseFornecedorDTO(fornecedor.getUserFornecedor(), token));
        }
        return ResponseEntity.badRequest().body("Usuário não encontrado");
    }

    @PostMapping("/register-fornecedor")
    public ResponseEntity<Object> registerFornecedor(@RequestBody RegisterRequestFornecedorDTO body) {
        Optional<Fornecedor> fornecedor = fornecedorRepository.findByEmailFornecedor(body.emailFornecedor());

        if (fornecedor.isEmpty()) {
            Fornecedor newFornecedor = new Fornecedor();
            newFornecedor.setSenhaFornecedor(passwordEncoder.encode(body.senhaFornecedor()));
            newFornecedor.setEmailFornecedor(body.emailFornecedor());
            newFornecedor.setNomeFornecedor(body.nomeFornecedor());
            fornecedorRepository.save(newFornecedor);

            String token = tokenService.generateTokenFornecedor(newFornecedor);
            return ResponseEntity.ok(new ResponseFornecedorDTO(newFornecedor.getNomeFornecedor(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}