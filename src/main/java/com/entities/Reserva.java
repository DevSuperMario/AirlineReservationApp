package com.entities;

import lombok.*;

import java.time.LocalDateTime;
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reserva {
    private int id;
    private Passageiro passageiro;
    private Voo voo;
    private LocalDateTime dataReserva;


}
