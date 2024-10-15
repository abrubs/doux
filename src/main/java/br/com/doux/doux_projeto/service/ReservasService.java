package br.com.doux.doux_projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.doux.doux_projeto.entity.Produtos;
import br.com.doux.doux_projeto.entity.Reservas;
import br.com.doux.doux_projeto.repository.ClientesRepository;
import br.com.doux.doux_projeto.repository.ProdutosRepository;
import br.com.doux.doux_projeto.repository.ReservasRepository;
import br.com.doux.doux_projeto.entity.Clientes;
import br.com.doux.doux_projeto.exception.ResourceNotFoundException;

import org.springframework.data.domain.Sort;


@Service
public class ReservasService {

    @Autowired
    private ReservasRepository reservasRepository;

    @Autowired
    private ClientesRepository clienteRepository;

    @Autowired 
    private ProdutosRepository produtoRepository;

    public List<Reservas> create(Reservas reservas){
        reservasRepository.save(reservas);
        return reservasRepository.findAll();
    }

    public List<Reservas> list(){
        List<Reservas> reservas = reservasRepository.findAll();

        reservas.forEach(reserva -> {
            Produtos produto = produtoRepository.findById(reserva.getIdProduto())
            .orElse(null);
            reserva.setProduto(produto);
        });

        reservas.forEach (reserva -> {
            Clientes cliente = clienteRepository.findById(reserva.getIdCliente())
            .orElse(null);
            reservas.setClientes(cliente);
        });

        return reservas;
    }

    public Reservas findById(Long id) {
      Optional<Reservas> reservasOptional = reservasRepository.findById(id);

      if (reservasOptional.isPresent()){
        Reservas reserva = reservasOptional.get();
        Produtos produto = produtoRepository.findById(Reservas.getidProduto()).orElse(null);
        reserva.setProduto(produto);
        return reserva;

      ? (reservasOptional.isPresent());
        Reservas reserva = reservasOptional.get();
        Clientes cliente = clienteRepository.findById(Reservas.getIdCliente()).orElse(null);
        reserva.setCliente(cliente);
        return reserva;
      }
      return null;
    }


    public List<Reservas> update(Reservas reservas){
        reservasRepository.save(reservas);
        return list();
    }

    public List<Reservas> delete(Long id){
        reservasRepository.deleteById(id);
        return list();
    } 

}    
