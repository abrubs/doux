package br.com.doux.doux_projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.doux.doux_projeto.entity.Funcionarios;
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
        Sort sort = Sort.by("PrioridadeFuncionario").descending().and(
        Sort.by("NomeFuncionario").ascending());
       return funcionariosRepository.findAll(sort);
    }

    public List<Funcionarios> update(Funcionarios funcionarios){
        funcionariosRepository.save(funcionarios);
        return list();
    }

    public List<Funcionarios> delete(Long id){
        funcionariosRepository.deleteById(id);
        return list();
    }
}
