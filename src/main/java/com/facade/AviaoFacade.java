package com.facade;

import com.applications.AviaoApplication;
import com.entities.Aviao;

import java.util.List;

public class AviaoFacade {
    private AviaoApplication aviaoApplication;

    public AviaoFacade(AviaoApplication aviaoApplication) {
        this.aviaoApplication = aviaoApplication;
    }

    public List<Aviao> getAll() {
        return this.aviaoApplication.getAll();
    }

    public Aviao getById(int id) {
        return this.aviaoApplication.getById(id);
    }

    public boolean exists(int id) {
        return this.aviaoApplication.exists(id);
    }

    public void append(Aviao append) {
        this.aviaoApplication.append(append);
    }

    public void remove(int id) {
        this.aviaoApplication.remove(id);
    }

    public void update(int id, Aviao aviao) {
        this.aviaoApplication.update(id, aviao);
    }

}
