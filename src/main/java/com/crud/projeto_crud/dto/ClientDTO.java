package com.crud.projeto_crud.dto;

import com.crud.projeto_crud.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class ClientDTO {

    @NotBlank(message = "Não pode ser vazio")
    private String name;
    private String cpf;
    private double income;
    @PastOrPresent(message = "Não pode ser data futura")
    private LocalDate birthDate;
    private Integer children;


    public ClientDTO(Client client) {
        name = client.getName();
        cpf = client.getCpf();
        income = client.getIncome();
        birthDate = client.getBirthDate();
        children = client.getChildren();
    }

    public ClientDTO() {
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
