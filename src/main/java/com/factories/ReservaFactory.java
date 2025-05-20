package com.factories;

import com.entities.Aviao;
import com.entities.Passageiro;
import com.entities.Reserva;
import com.entities.Voo;

import java.time.LocalDateTime;

public class ReservaFactory extends Reserva {
    private static int id = 0;

    public ReservaFactory(Passageiro passageiro,
                          Voo voo,
                          LocalDateTime dataReserva) {
        super(id++, passageiro, voo, dataReserva);

    }

}

