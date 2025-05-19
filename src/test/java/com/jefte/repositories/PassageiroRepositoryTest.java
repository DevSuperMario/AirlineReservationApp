package com.jefte.repositories;

import com.jefte.entities.Passageiro;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PassageiroRepositoryTest {
    private PassageiroRepository passageiroRepository;
    private Passageiro passageiroValido;
    private Passageiro passageiroImvalido;

    @BeforeEach
    public void setUp() {
        passageiroRepository = new PassageiroRepository();
        passageiroValido = new Passageiro(1, "John Doe", "09920607029", "tMw0L@example.com");
        passageiroImvalido = new Passageiro(2, "Jane Doe", "0101010101010", "Hl9Y0examplecom");
    }

    @Test
    public void testCPFValido() {

        Assertions.assertTrue(passageiroValido.isValidCPF(passageiroValido.getCpf()));
    }

    @Test
    public void testCPFInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> passageiroImvalido.isValidCPF(passageiroImvalido.getCpf()));

    }

    @Test
    public void testEmailValido() {
        Assertions.assertTrue(passageiroValido.isValidEmail(passageiroValido.getEmail()));
    }

    @Test
    public void testEmailInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> passageiroImvalido.isValidEmail(passageiroImvalido.getCpf()));

    }

    @Test
    public void testCadastroPassageiro() {
        passageiroRepository.append(passageiroValido);
        Assertions.assertTrue(passageiroRepository.getAll().contains(passageiroValido));

        Assertions.assertThrows(IllegalArgumentException.class, () -> passageiroRepository.append(passageiroImvalido));

    }

}