package com.factories;

import com.entities.Aviao;
import com.entities.Voo;

import java.time.LocalDateTime;

public class AviaoFactory extends Aviao {
    private static int id = 0;

    public AviaoFactory(String modelo,
                        int capacidade,
                        String fabricante) {
        super(id++, modelo, capacidade, fabricante);
    }

}
