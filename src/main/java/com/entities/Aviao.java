package com.entities;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Aviao {
    private int id;
    private String modelo;
    private int capacidade;
    private String fabricante;

    public Aviao correct() {
        if (this.capacidade <= 0) {
            throw new IllegalArgumentException("Capacidade must be greater than 0");
        }
        return this;
    }

}
