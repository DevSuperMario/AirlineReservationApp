package com.repositories;

import com.entities.Reserva;

import java.util.ArrayList;
import java.util.List;

public class ReservaRepository {
    private List<Reserva> reservas = new ArrayList<Reserva>();

    public List<Reserva> getAll() {
        return reservas;
    }

    public Reserva getById(int id) {
        return reservas.stream().filter(p -> p.getId() == id).findFirst().get();
    }

    public boolean exists(int id) {
        return reservas.stream().anyMatch(p -> p.getId() == id);
    }

    public void append(Reserva reserva) {
        reservas.add(reserva);
    }

    public void remove(int id) {
        reservas.removeIf(reserva -> reserva.getId() == id);
    }

    public void update(int id, Reserva reserva) {
        Reserva reservaInDb = reservas.stream().filter(p -> p.getId() == id).findFirst().get();

        reservaInDb.setId(reserva.getId());
        reservaInDb.setPassageiro(reserva.getPassageiro() != null ? reserva.getPassageiro() : reservaInDb.getPassageiro());
        reservaInDb.setVoo(reserva.getVoo() != null ? reserva.getVoo() : reservaInDb.getVoo());
        reservaInDb.setDataReserva(reserva.getDataReserva() != null ? reserva.getDataReserva() : reservaInDb.getDataReserva());

    }
}