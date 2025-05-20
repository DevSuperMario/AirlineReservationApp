package com.repositories;

import com.entities.Aviao;

import java.util.ArrayList;
import java.util.List;

public class AviaoRepository {
    private List<Aviao> aviaos = new ArrayList<Aviao>();


    public List<Aviao> getAll() {
        return aviaos;
    }

    public Aviao getById(int id) {
        return aviaos.stream().filter(p -> p.getId() == id).findFirst().get();
    }

    public boolean exists(int id) {
        return aviaos.stream().anyMatch(p -> p.getId() == id);
    }

    public void append(Aviao aviao) {
        aviaos.add(aviao.correct());
    }

    public void remove(int id) {
        aviaos.removeIf(Aviao -> Aviao.getId() == id);
    }

    public void update(int id, Aviao Aviao) {
        Aviao aviaoInDb = aviaos.stream().filter(p -> p.getId() == id).findFirst().get();

        aviaoInDb.setId(Aviao.getId());
        aviaoInDb.setCapacidade(Aviao.getCapacidade() > 0 ? Aviao.getCapacidade() : aviaoInDb.getCapacidade());
        aviaoInDb.setFabricante(Aviao.getFabricante() != null ? Aviao.getFabricante() : aviaoInDb.getFabricante());
        aviaoInDb.setModelo(Aviao.getModelo() != null ? Aviao.getModelo() : aviaoInDb.getModelo());
    }
}