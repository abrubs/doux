package br.com.doux.doux_projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.doux.doux_projeto.entity.Clientes;
import br.com.doux.doux_projeto.entity.Produtos;
import br.com.doux.doux_projeto.entity.Reservas;
import br.com.doux.doux_projeto.exception.ResourceNotFoundException;
import br.com.doux.doux_projeto.repository.ClientesRepository;
import br.com.doux.doux_projeto.repository.ProdutosRepository;
import br.com.doux.doux_projeto.repository.ReservasRepository;


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

            Clientes cliente = clienteRepository.findById(reserva.getIdCliente())
            .orElse(null);

            reserva.setCliente(cliente);
        });

        return reservas;
    }

    public Reservas findById(Long id) {
      Optional<Reservas> reservasOptional = reservasRepository.findById(id);

      if (reservasOptional.isPresent()){
        Reservas reserva = reservasOptional.get();

        Produtos produto = produtoRepository.findById(reserva.getIdProduto()).orElse(null);
        reserva.setProduto(produto);

        Clientes cliente = clienteRepository.findById(reserva.getIdCliente()).orElse(null);
        reserva.setCliente(cliente);

        return reserva;
      }
      return null;
    }


    public List<Reservas> update(Reservas reservas){
        reservasRepository.save(reservas);
        return list();
    }

    public List<Reservas> update(Long id, Reservas reservas) {
      
        Reservas existingReserva = reservasRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva não encontrado com id " + id));

        existingReserva.setIdCliente(reservas.getIdCliente());
        existingReserva.setIdProduto(reservas.getIdProduto());
        existingReserva.setQuantidade(reservas.getQuantidade());
        existingReserva.setDataReserva(reservas.getDataReserva());
        existingReserva.setStatusReserva(reservas.getStatusReserva());
        existingReserva.setPrioridadeReserva(reservas.getPrioridadeReserva());

        reservasRepository.save(existingReserva);

        return list();
    }

    public List<Reservas> delete(Long id){
        reservasRepository.deleteById(id);
        return list();
    }
}    
