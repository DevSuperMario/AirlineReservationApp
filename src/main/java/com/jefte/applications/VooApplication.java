package com.jefte.applications;

import com.jefte.entities.Voo;
import com.jefte.repositories.VooRepository;

import java.util.List;

public class VooApplication {
    private VooRepository vooRepository;
    private ReservaApplication reservaApplication;


    public VooApplication(VooRepository vooRepository, ReservaApplication reservaApplication) {
        this.vooRepository = vooRepository;
        this.reservaApplication = reservaApplication;

    }

    public List<Voo> getAll() {
        return this.vooRepository.getAll();
    }

    public Voo getById(int id) {
        return this.vooRepository.getById(id);
    }

    public boolean exists(int id) {
        return this.vooRepository.exists(id);
    }

    public void append(Voo voo) {
        this.vooRepository.append(voo);

    }

    public void remove(int id) {
        this.vooRepository.remove(id);

    }

    public void update(int id, Voo voo) {

        this.vooRepository.update(id, voo);

    }

}
