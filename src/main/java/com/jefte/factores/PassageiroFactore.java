package com.jefte.factores;


import com.jefte.entities.Passageiro;

public class PassageiroFactore extends Passageiro {
    private static int id = 0;

    public PassageiroFactore(String nome,
                              String cpf,
                              String email) {
        super(id++, nome, cpf, email);
    }

}


