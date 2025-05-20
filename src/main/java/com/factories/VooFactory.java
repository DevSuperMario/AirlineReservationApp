package com.factories;

import com.entities.Aviao;
import com.entities.Voo;

import java.time.LocalDateTime;

public class VooFactory extends Voo {
    private static int id = 0;

    public VooFactory(String origem,
                      String destino,
                      LocalDateTime dataHora,
                      Aviao aviao) {
        super(id++, origem, destino, dataHora, aviao);
    }

}