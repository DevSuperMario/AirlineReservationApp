package com.repositories;

import com.entities.Voo;

import java.util.ArrayList;
import java.util.List;

public class VooRepository {
    private List<Voo> voos = new ArrayList<Voo>();

    public List<Voo> getAll() {
        return voos;
    }

    public Voo getById(int id) {
        Voo voo = voos.stream().filter(p -> p.getId() == id).findFirst().get();
        return voo;
    }

    public boolean exists(int id) {
        return voos.stream().anyMatch(p -> p.getId() == id);
    }

    public void append(Voo voo) {
        voos.add(voo);
    }

    public void remove(int id) {
        voos.removeIf(Voo -> Voo.getId() == id);
    }

    public void update(int id, Voo Voo) {
        Voo VooInDb = voos.stream().filter(p -> p.getId() == id).findFirst().get();

        VooInDb.setId(Voo.getId());
        VooInDb.setAviao(Voo.getAviao() != null ? Voo.getAviao() : VooInDb.getAviao());
        VooInDb.setDestino(Voo.getDestino() != null ? Voo.getDestino() : VooInDb.getDestino());
        VooInDb.setOrigem(Voo.getOrigem() != null ? Voo.getOrigem() : VooInDb.getOrigem());
        VooInDb.setDataHora(Voo.getDataHora() != null ? Voo.getDataHora() : VooInDb.getDataHora());

    }
}