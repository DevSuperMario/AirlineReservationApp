package com.jefte.applications;

import com.jefte.entities.Aviao;
import com.jefte.repositories.AviaoRepository;

import java.util.List;

public class AviaoApplication {
    private AviaoRepository aviaoRepository;
    
 
    public AviaoApplication(AviaoRepository aviaoRepository) {
        this.aviaoRepository = aviaoRepository;

    }

    public List<Aviao> getAll() {
        return this.aviaoRepository.getAll();
    }

    public Aviao getById(int id) {
        return this.aviaoRepository.getById(id);
    }

    public boolean exists(int id) {
        return this.aviaoRepository.exists(id);
    }

    public void append(Aviao aviao) {
        this.aviaoRepository.append(aviao.correct());

    }

    public void remove(int id) {
        this.aviaoRepository.remove(id);

    }

    public void update(int id, Aviao aviao) {
        this.aviaoRepository.update(id, aviao);

    }

}
