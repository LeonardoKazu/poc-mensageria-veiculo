package com.leonardokazu.poc_mensageria_docker.controllers;

import com.leonardokazu.poc_mensageria_docker.model.VeiculoRequest;
import com.leonardokazu.poc_mensageria_docker.service.VeiculoService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private static final Logger logger = LoggerFactory.getLogger(VeiculoController.class);

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @PostMapping("/batch")
    public void cadastrarVeiculo(@RequestBody @Valid List<VeiculoRequest> veiculos){
        logger.info("[CONTROLLER] Requisição recebida em: {}", java.time.LocalTime.now());
        veiculoService.iniciarCadastroVeiculo(veiculos);
        logger.info("[CONTROLLER] Respondendo ao cliente em: {}", java.time.LocalTime.now());
    }
}
