package com.factories;


import com.entities.Passageiro;

public class PassageiroFactory extends Passageiro {
    private static int id = 0;

    public PassageiroFactory(String nome,
                              String cpf,
                              String email) {
        super(id++, nome, cpf, email);
    }

}


