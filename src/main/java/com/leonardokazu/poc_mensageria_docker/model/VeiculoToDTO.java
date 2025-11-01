package com.leonardokazu.poc_mensageria_docker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoToDTO {
    public String placa;
    public String modelo;
    public String categoria;
}
