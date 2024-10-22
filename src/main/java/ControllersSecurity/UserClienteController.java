package ControllersSecurity;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/userCliente")
public class UserClienteController {
    @GetMapping
     public ResponseEntity<String> getUserCliente(){
        return ResponseEntity.ok("Sucesso!");
   }
}
