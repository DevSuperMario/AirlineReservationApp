package com.jefte.factores;

import com.jefte.entities.Aviao;
import com.jefte.entities.Passageiro;
import com.jefte.entities.Reserva;
import com.jefte.entities.Voo;

import java.time.LocalDateTime;

public class ReservaFactore extends Reserva {
    private static int id = 0;

    public ReservaFactore(Passageiro passageiro,
                          Voo voo,
                          LocalDateTime dataReserva) {
        super(id++, passageiro, voo, dataReserva);

    }

}

