package com.leonardokazu.poc_mensageria_docker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo implements Serializable {
    public String placa;
    public String modelo;
    public String categoria;
}
