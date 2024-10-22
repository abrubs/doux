package br.com.doux.doux_projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.doux.doux_projeto.entity.Clientes;
import br.com.doux.doux_projeto.exception.ResourceNotFoundException;
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
            Sort.by("UserCliente") .ascending());
            return clientesRepository.findAll(sort);
    }

    public Clientes findById(Long id) {
        return clientesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id " + id));
    }

    public Clientes update(Long id, Clientes clientes) {
        // Verifica se o cliente existe
        Clientes existingCliente = clientesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id " + id));

        // Atualiza os campos do cliente existente
        existingCliente.setNomeCompletoCliente(clientes.getNomeCompletoCliente());
        existingCliente.setUserCliente(clientes.getUserCliente());
        existingCliente.setEmailCliente(clientes.getEmailCliente());
        existingCliente.setTelefoneCliente(clientes.getTelefoneCliente());
        existingCliente.setSenhaCliente(clientes.getSenhaCliente());
        existingCliente.setPrioridadeCliente(clientes.getPrioridadeCliente());

        // Salva o cliente atualizado
        return clientesRepository.save(existingCliente);
    }
    
    public List<Clientes> delete(Long id) {
        clientesRepository.deleteById(id);
        return list();
    }
}
