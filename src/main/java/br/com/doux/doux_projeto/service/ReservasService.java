package br.com.doux.doux_projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.doux.doux_projeto.entity.Reservas;
import br.com.doux.doux_projeto.repository.ReservasRepository;

@Service
public class ReservasService {

    @Autowired
    private ReservasRepository reservasRepository;

   public List<Reservas> create(Reservas reservas) {
       reservasRepository.save(reservas);
       return list();
   }

   public List<Reservas> list() {
    Sort sort = Sort.by("PrioridadeReserva").descending().and(
        Sort.by("IdReserva").ascending());
        return reservasRepository.findAll(sort);
   }

   public List<Reservas> update(Reservas reservas) {
       reservasRepository.save(reservas);
       return list();
   }

   public List<Reservas> delete(Long id) {
       reservasRepository.deleteById(id);
       return list();
   }
}
