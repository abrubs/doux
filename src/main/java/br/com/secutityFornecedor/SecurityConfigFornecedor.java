package br.com.secutityFornecedor;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;



@Configuration
@EnableWebSecurity
public class SecurityConfigFornecedor {

    @Autowired
    private CustomFornecedorDetailsService fornecedorDetailsService;

    @Autowired
    SecurityFilterFornecedor securityFilter;

    @Bean(name="2")
    public SecurityFilterChain securityFilterChainFornecedor(HttpSecurity http) throws Exception {
        http

             .cors().configurationSource(corsConfigurationSourceFornecedor())
             .and()
             .csrf(csrf -> csrf.disable())
             .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
             .authorizeHttpRequests(authorize -> authorize
                .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                .requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                .anyRequest().authenticated() )
             .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
             return http.build();
    }
   
    @Bean(name = "passwordEncoderFornecedor")
    public PasswordEncoder passwordEncoderFornecedor(){return new BCryptPasswordEncoder();}

    
    @Bean("clienteAuthManager")
    public AuthenticationManager clienteAuthenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean("fornecedorAuthManager")
    public AuthenticationManager fornecedorAuthenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
    public AuthenticationManager authenticationManagerFornecedor(AuthenticationConfiguration authenticationConfiguration) throws Exception{
       return authenticationConfiguration.getAuthenticationManager();
    }

      @Bean(name = "corsConfigurationSourceFornecedor")
      public CorsConfigurationSource corsConfigurationSourceFornecedor() {
         CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedOrigins(List.of("http://127.0.0.2:5500"));
            configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
            configuration.setAllowedHeaders(List.of("Authorization", "Content-Type"));
            configuration.setAllowCredentials(true);
   
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", configuration);
            return source;
         }
         }   

