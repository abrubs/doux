package br.com.doux.doux_projeto.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.doux.doux_projeto.entity.Funcionarios;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    
    public String generateToken(Funcionarios funcionarios) {
        return generateTokenGeneric(funcionarios.getEmailFuncionario());
    }

    


    private String generateTokenGeneric(String email) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                             .withIssuer("login-auth-api")
                             .withSubject(email)
                             .withExpiresAt(this.generateExpirationDate())
                             .sign(algorithm);
            return token;

        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao autenticar");
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                      .withIssuer("login-auth-api")
                      .build()
                      .verify(token)
                      .getSubject();
        } catch (JWTVerificationException exception) {
            return null;   
        }
    }

    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.ofHours(-3));
    }
}