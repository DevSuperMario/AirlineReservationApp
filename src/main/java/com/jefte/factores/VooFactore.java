package com.jefte.factores;

import com.jefte.entities.Aviao;
import com.jefte.entities.Voo;

import java.time.LocalDateTime;

public class VooFactore extends Voo {
    private static int id = 0;

    public VooFactore(String origem,
                      String destino,
                      LocalDateTime dataHora,
                      Aviao aviao) {
        super(id++, origem, destino, dataHora, aviao);
    }

}