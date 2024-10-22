package ControllersSecurity;

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
import br.com.doux.doux_projeto.repository.ClientesRepository;
import br.com.doux.doux_projeto.securityCliente.TokenService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final ClientesRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        Clientes cliente = this.repository.findByEmailCliente(body.emailCliente()).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        if(passwordEncoder.matches(cliente.getSenhaCliente(), body.senhaCliente())){
            String token = this.tokenService.generateToken(cliente);
            return ResponseEntity.ok(new ResponseDTO(cliente.getNomeCliente(), token));
        }
        return ResponseEntity.badRequest().build();
        }

        @PostMapping("/register")
        public ResponseEntity register(@RequestBody RegisterRequestDTO body){
            Optional<Clientes> cliente = this.repository.findByEmailCliente(body.emailCliente());

            if(cliente.isEmpty()){
           Clientes newCliente = new Clientes();
           newCliente.setSenhaCliente(passwordEncoder.encode(body.senhaCliente()));
           newCliente.setEmailCliente(body.emailCliente());
           newCliente.setNomeCliente(body.nomeCliente());
           this.repository.save(newCliente);
          
                String token = this.tokenService.generateToken(newCliente);
                return ResponseEntity.ok(new ResponseDTO(newCliente.getNomeCliente(), token));
             }
            return ResponseEntity.badRequest().build();
            }
        
        }

