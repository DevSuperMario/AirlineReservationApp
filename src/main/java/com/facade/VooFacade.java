package com.facade;

import com.applications.VooApplication;
import com.entities.Voo;

import java.util.List;

public class VooFacade {
    private VooApplication vooApplication;

    public VooFacade(VooApplication vooApplication) {
        this.vooApplication = vooApplication;
    }

    public List<Voo> getAll() {
        return this.vooApplication.getAll();
    }

    public Voo getById(int id) {
        return this.vooApplication.getById(id);
    }

    public boolean exists(int id) {
        return this.vooApplication.exists(id);
    }

    public void append(Voo voo) {
        this.vooApplication.append(voo);
    }

    public void remove(int id) {
        this.vooApplication.remove(id);
    }

    public void update(int id, Voo voo) {
        this.vooApplication.update(id, voo);
    }

}
