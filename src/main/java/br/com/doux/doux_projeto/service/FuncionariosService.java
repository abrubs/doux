package br.com.doux.doux_projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.doux.doux_projeto.entity.Funcionarios;
import br.com.doux.doux_projeto.exception.ResourceNotFoundException;
import br.com.doux.doux_projeto.repository.FuncionariosRepository;

@Service
public class FuncionariosService {

    @Autowired
    private FuncionariosRepository funcionariosRepository;

   
    public List<Funcionarios> create(Funcionarios funcionarios){
        funcionariosRepository.save(funcionarios);
        return list();
    }

    public List<Funcionarios> list(){
        Sort sort = Sort.by("prioridadeFuncionario").descending().and(
        Sort.by("nomeFuncionario").ascending());
       return funcionariosRepository.findAll(sort);
    }

    public Funcionarios findById(Long id){
        return funcionariosRepository.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Funcionario não encontrado com id"+ id));

    }

    public Funcionarios update(Long id, Funcionarios funcionarios){
        Funcionarios existingFuncionarios = funcionariosRepository.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Funcionario não encontrado com id"+ id));
    
        existingFuncionarios.setUserFuncionario(funcionarios.getUserFuncionario());
        existingFuncionarios.setEmailFuncionario(funcionarios.getEmailFuncionario());
        existingFuncionarios.setTelefoneFuncionario(funcionarios.getTelefoneFuncionario());
        existingFuncionarios.setFuncaoFuncionario(funcionarios.getFuncaoFuncionario());
        existingFuncionarios.setSenhaFuncionario(funcionarios.getSenhaFuncionario());
        existingFuncionarios.setPrioridadeFuncionario(funcionarios.getPrioridadeFuncionario());
      
    return funcionariosRepository.save(existingFuncionarios);

    }

    public List<Funcionarios> delete(Long id){
        funcionariosRepository.deleteById(id);
        return list();
    }
}
