package br.com.doux.doux_projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.doux.doux_projeto.entity.Fornecedor;
import br.com.doux.doux_projeto.exception.ResourceNotFoundException;
import br.com.doux.doux_projeto.repository.FornecedorRepository;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Fornecedor> create(Fornecedor fornecedor){
        fornecedorRepository.save(fornecedor);
        return list();
    }

    public List<Fornecedor> list(){
        Sort sort = Sort.by("PrioridadeFornecedor").descending().and(
        Sort.by("nomeFornecedor").ascending());
        return fornecedorRepository.findAll(sort);
    }

    public Fornecedor findById(Long id){
      return fornecedorRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Fornecedor não encontrado com id"+ id));
    }

      public Fornecedor update(Long id, Fornecedor fornecedor){
        Fornecedor existingFornecedor = fornecedorRepository.findById(id)
       .orElseThrow(() -> new ResourceNotFoundException("Fornecedor não encontrado com id"+ id));
      
       existingFornecedor.setUserFornecedor(fornecedor.getUserFornecedor());
       existingFornecedor.setEmailFornecedor(fornecedor.getEmailFornecedor());
       existingFornecedor.setTelefoneFornecedor(fornecedor.getTelefoneFornecedor());
       existingFornecedor.setEnderecoFornecedor(fornecedor.getEnderecoFornecedor());
       existingFornecedor.setCnpj(fornecedor.getCnpj());
       existingFornecedor.setDataCadastro(fornecedor.getDataCadastro());
       existingFornecedor.setPrioridadeFornecedor(fornecedor.getPrioridadeFornecedor());

       return fornecedorRepository.save(existingFornecedor);
    }
      
    public List<Fornecedor> delete(Long id){
        fornecedorRepository.deleteById(id);
        return list();
    }

    }

   

