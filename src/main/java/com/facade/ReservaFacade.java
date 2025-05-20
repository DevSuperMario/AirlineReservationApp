package com.facade;

import com.applications.ReservaApplication;
import com.entities.Reserva;

import java.util.List;

public class ReservaFacade {
    private ReservaApplication reservaApplication;

    public ReservaFacade(ReservaApplication reservaApplication) {
        this.reservaApplication = reservaApplication;
    }

    public List<Reserva> getAll() {
        return this.reservaApplication.getAll();
    }

    public Reserva getById(int id) {
        return this.reservaApplication.getById(id);
    }

    public boolean exists(int id) {
        return this.reservaApplication.exists(id);
    }

    public void append(Reserva reserva) {
        this.reservaApplication.append(reserva);
    }

    public void remove(int id) {
        this.reservaApplication.remove(id);
    }

    public void update(int id, Reserva reserva) {
        this.reservaApplication.update(id, reserva);
    }

}
