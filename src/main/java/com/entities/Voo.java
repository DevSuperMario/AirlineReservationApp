package com.entities;

import lombok.*;

import java.time.LocalDateTime;
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Voo {
    private int id;
    private String origem;
    private String destino;
    private LocalDateTime dataHora;
    private Aviao aviao;



}
