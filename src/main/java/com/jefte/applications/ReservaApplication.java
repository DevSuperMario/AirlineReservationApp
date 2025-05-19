package com.jefte.applications;

import com.jefte.entities.Reserva;
import com.jefte.entities.Voo;
import com.jefte.repositories.ReservaRepository;

import java.util.List;

public class ReservaApplication {
    private ReservaRepository reservaRepository;



    public ReservaApplication(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;

    }

    public List<Reserva> getAll() {
        return this.reservaRepository.getAll();
    }

    public Reserva getById(int id) {
        return this.reservaRepository.getById(id);
    }

    public boolean exists(int id) {
        return this.reservaRepository.exists(id);
    }

    public void append(Reserva reserva) {
        if (vagasDisponiveis(reserva.getVoo())) {
            this.reservaRepository.append(reserva);
        } else {
            System.out.println("Não há vagas disponíveis para o voo " + reserva.getVoo().getId());
        }

    }

    public boolean vagasDisponiveis(Voo voo) {
        long reservas = this.reservaRepository.getAll().stream()
                .filter(reserva -> reserva.getVoo().getId() == voo.getId())
                .count();

        int assentos = voo.getAviao().getCapacidade();

        if (reservas < assentos) {
            return true;
        } else {
            return false;
        }
    }

    public void remove(int id) {
        this.reservaRepository.remove(id);

    }

    public void update(int id, Reserva reserva) {
        this.reservaRepository.update(id, reserva);

    }

}
