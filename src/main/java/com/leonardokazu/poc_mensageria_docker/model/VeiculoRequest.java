package com.leonardokazu.poc_mensageria_docker.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class VeiculoRequest{
    @NotBlank(message = "Placa não pode ser vazio.")
    public String placa;

    @NotBlank(message = "Modelo não pode ser vazio.")
    public String modelo;

    @NotBlank(message = "Categoria não pode ser vazio.")
    public String categoria;
}
