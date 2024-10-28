package ControllersSecurity;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/userFuncionario")
public class UserFuncionarioController {
    @GetMapping
     public ResponseEntity<String> getUserFuncionario(){
        return ResponseEntity.ok("Sucesso!");
   }
}

