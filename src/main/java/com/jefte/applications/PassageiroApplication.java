package com.jefte.applications;
import com.jefte.entities.Passageiro;
import com.jefte.repositories.PassageiroRepository;


import java.util.List;

public class PassageiroApplication {
    private PassageiroRepository passageiroRepository;
    
 
    public PassageiroApplication(PassageiroRepository passageiroRepository) {
        this.passageiroRepository = passageiroRepository;

    }

    public List<Passageiro> getAll() {
        return this.passageiroRepository.getAll();
    }

    public Passageiro getById(int id) {
        return this.passageiroRepository.getById(id);
    }

    public boolean exists(int id) {
        return this.passageiroRepository.exists(id);
    }

    public void append(Passageiro passageiro) {
        this.passageiroRepository.append(passageiro.correct());

    }

    public void remove(int id) {
        this.passageiroRepository.remove(id);

    }

    public void update(int id, Passageiro Passageiro) {
        this.passageiroRepository.update(id, Passageiro);

    }

}
