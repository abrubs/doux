package br.com.doux.doux_projeto.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import br.com.doux.doux_projeto.entity.Fornecedor;
import br.com.doux.doux_projeto.repository.FornecedorRepository;
import br.com.doux.dtoFornecedor.LoginRequestFornecedorDTO;
import br.com.doux.dtoFornecedor.RegisterRequestFornecedorDTO;
import br.com.doux.dtoFornecedor.ResponseFornecedorDTO;
import br.com.secutityFornecedor.TokenServiceFornecedor;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthControllerFornecedor {
     
    private final FornecedorRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenServiceFornecedor tokenServiceFornecedor;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequestFornecedorDTO body){
        Fornecedor fornecedor = this.repository.findByEmailFornecedor(body.emailFornecedor())
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
            System.out.println(fornecedor);
        if (passwordEncoder.matches(body.senhaFornecedor(), fornecedor.getSenhaFornecedor())){
            String token = this.tokenServiceFornecedor.generateTokenFornecedor(fornecedor);
            return ResponseEntity.ok(new ResponseFornecedorDTO(fornecedor.getUserFornecedor(), token));
        }  
        return ResponseEntity.badRequest().body("Usuário não encontrado");
        
    }


 
    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegisterRequestFornecedorDTO body){
        Optional<Fornecedor> fornecedor = this.repository.findByEmailFornecedor(body.emailFornecedor());

        System.out.println(fornecedor);
        if (fornecedor.isEmpty()){
            Fornecedor newFornecedor = new Fornecedor();
            newFornecedor.setSenhaFornecedor(passwordEncoder.encode(body.senhaFornecedor()));
            newFornecedor.setEmailFornecedor(body.emailFornecedor());
            newFornecedor.setNomeFornecedor(body.nomeFornecedor());
            this.repository.save(newFornecedor);

            String token = this.tokenServiceFornecedor.generateTokenFornecedor(newFornecedor);
            return ResponseEntity.ok(new ResponseFornecedorDTO(newFornecedor.getNomeFornecedor(), token));

        }
        return ResponseEntity.badRequest().build();
    }
}



