package ControllersSecurity;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/userFornecedor")
public class UserFornecedorController {
    @GetMapping
     public ResponseEntity<String> getUserFornecedor(){
        return ResponseEntity.ok("Sucesso!");
   }
}
