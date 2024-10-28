package br.com.doux.doux_projeto.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.doux.doux_projeto.dtoFuncionario.LoginRequestDTO;
import br.com.doux.doux_projeto.dtoFuncionario.RegisterRequestDTO;
import br.com.doux.doux_projeto.dtoFuncionario.ResponseDTO;
import br.com.doux.doux_projeto.entity.Funcionarios;
import br.com.doux.doux_projeto.repository.FuncionariosRepository;
import br.com.doux.doux_projeto.security.TokenService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthControllerr {
    
    private final FuncionariosRepository funcionariosRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequestDTO body) {
        Funcionarios funcionario= funcionariosRepository.findByEmailFuncionario(body.emailFuncionario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        
        if (passwordEncoder.matches(body.senhaFuncionario(), funcionario.getSenhaFuncionario())) {
            String token = tokenService.generateToken(funcionario);
            return ResponseEntity.ok(new ResponseDTO(funcionario.getNomeFuncionario(), token));
        }
        return ResponseEntity.badRequest().body("Usuário não encontrado");
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegisterRequestDTO body) {
        Optional<Funcionarios> funcionario = funcionariosRepository.findByEmailFuncionario(body.emailFuncionario());

        if (funcionario.isEmpty()) {
            Funcionarios newFuncionario = new Funcionarios();
            newFuncionario.setSenhaFuncionario(passwordEncoder.encode(body.senhaFuncionario()));
            newFuncionario.setEmailFuncionario(body.emailFuncionario());
            newFuncionario.setNomeFuncionario(body.nomeFuncionario());
            funcionariosRepository.save(newFuncionario);

            String token = tokenService.generateToken(newFuncionario);
            return ResponseEntity.ok(new ResponseDTO(newFuncionario.getNomeFuncionario(), token));
        }
        return ResponseEntity.badRequest().build();
    }
    
}
