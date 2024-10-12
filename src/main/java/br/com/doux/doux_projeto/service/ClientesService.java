package br.com.doux.doux_projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.doux.doux_projeto.entity.Clientes;
import br.com.doux.doux_projeto.repository.ClientesRepository;

@Service
public class ClientesService {
    
    @Autowired
   private ClientesRepository clientesRepository;


    public List<Clientes> create(Clientes clientes) {
        clientesRepository.save(clientes);
        return list();
    }
    
    public List<Clientes> list() {
       Sort sort = Sort.by("PrioridadeCliente").descending().and(
            Sort.by("NomeCliente") .ascending());
            return clientesRepository.findAll(sort);
    }
    
    public List<Clientes> update(Clientes clientes) {
        clientesRepository.save(clientes);
        return list();
    }
    
    public List<Clientes> delete(Long id) {
        clientesRepository.deleteById(id);
        return list();
    }
}
