package com.jefte.facade;
import com.jefte.applications.PassageiroApplication;
import com.jefte.entities.Passageiro;
import java.util.List;

public class PassageiroFacade {
    private PassageiroApplication PassageiroApplication;

    public PassageiroFacade(PassageiroApplication PassageiroApplication) {
        this.PassageiroApplication = PassageiroApplication;
    }

    public List<Passageiro> getAll() {
        return this.PassageiroApplication.getAll();
    }

    public Passageiro getById(int id) {
        return this.PassageiroApplication.getById(id);
    }

    public boolean exists(int id) {
        return this.PassageiroApplication.exists(id);
    }

    public void append(Passageiro Passageiro) {
        this.PassageiroApplication.append(Passageiro);
    }

    public void remove(int id) {
        this.PassageiroApplication.remove(id);
    }

    public void update(int id, Passageiro Passageiro) {
        this.PassageiroApplication.update(id, Passageiro);
    }

}
