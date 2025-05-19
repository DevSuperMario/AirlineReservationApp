package com.jefte.factores;

import com.jefte.entities.Aviao;
import com.jefte.entities.Voo;

import java.time.LocalDateTime;

public class AviaoFactore extends Aviao {
    private static int id = 0;

    public AviaoFactore(String modelo,
                        int capacidade,
                        String fabricante) {
        super(id++, modelo, capacidade, fabricante);
    }

}
