package com.jefte.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Passageiro {
    private int id;
    private String nome;
    private String cpf;
    private String email;

   
    public void setCpf(String cpf) {
        if (!isValidCPF(cpf)) {
            throw new IllegalArgumentException("Invalid CPF");
        }
        this.cpf = cpf;
    }

    public Passageiro correct(){
        isValidCPF(this.cpf);
        isValidEmail(this.email);
        return this;
    }

    public void setEmail(String email) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email");
        }
        this.email = email;
    }

    public boolean isValidCPF(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            throw new IllegalArgumentException("Invalid CPF");
        }

        int[] digits = new int[11];
        for (int i = 0; i < 11; i++) {
            digits[i] = Integer.parseInt(String.valueOf(cpf.charAt(i)));
        }

        int sum = 0;
        int weight = 10;
        for (int i = 0; i < 9; i++) {
            sum += digits[i] * weight;
            weight--;
        }

        int checkingDigit = 11 - sum % 11;
        if (checkingDigit > 9) {
            checkingDigit = 0;
        }

        if (digits[9] != checkingDigit) {
            return false;
        }

        sum = 0;
        weight = 11;
        for (int i = 0; i < 10; i++) {
            sum += digits[i] * weight;
            weight--;
        }

        checkingDigit = 11 - sum % 11;
        if (checkingDigit > 9) {
            checkingDigit = 0;
        }

        return digits[10] == checkingDigit;
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if (email.matches(emailRegex)) {
            return true;
        } else {
            throw new IllegalArgumentException("Invalid email");
        }

    }

}