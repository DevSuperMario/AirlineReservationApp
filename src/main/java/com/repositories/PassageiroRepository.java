package com.repositories;

import com.entities.Passageiro;

import java.util.ArrayList;
import java.util.List;
public class PassageiroRepository {
    private List<Passageiro> passageiros = new ArrayList<Passageiro>();

    public List<Passageiro> getAll() {
        return passageiros;
    }

    public Passageiro getById(int id) {
        return passageiros.stream().filter(p -> p.getId() == id).findFirst().get();
    }

    public boolean exists(int id) {
        return passageiros.stream().anyMatch(p -> p.getId() == id);
    }

    public void append(Passageiro passageiro) {
        passageiros.add(passageiro.correct());
    }

    public void remove(int id) {
        passageiros.removeIf(passageiro -> passageiro.getId() == id);
    }

    public void update(int id, Passageiro passageiro) {
        Passageiro PassageiroInDb = passageiros.stream().filter(p -> p.getId() == id).findFirst().get();

        PassageiroInDb.setId(passageiro.getId());
        PassageiroInDb.setNome(passageiro.getNome());
        PassageiroInDb.setCpf(passageiro.getCpf());
        PassageiroInDb.setEmail(passageiro.getEmail());
    }
}