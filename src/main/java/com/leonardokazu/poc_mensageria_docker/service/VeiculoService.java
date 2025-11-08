package com.leonardokazu.poc_mensageria_docker.service;

import com.leonardokazu.poc_mensageria_docker.VeiculoRepository;
import com.leonardokazu.poc_mensageria_docker.model.VeiculoRequest;
import com.leonardokazu.poc_mensageria_docker.model.VeiculoToDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {
    private static final Logger logger = LoggerFactory.getLogger(VeiculoService.class);
    
    private final VeiculoProducer veiculoProducer;

    private final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoProducer veiculoProducer, VeiculoRepository veiculoRepository) {
        this.veiculoProducer = veiculoProducer;
        this.veiculoRepository = veiculoRepository;
    }

    public void iniciarCadastroVeiculo(List<VeiculoRequest> veiculoRequests){
        veiculoRequests.forEach(veiculoRequest -> {
            VeiculoToDTO veiculo = new VeiculoToDTO(veiculoRequest.getPlaca(), veiculoRequest.getModelo(), veiculoRequest.getCategoria());
            try {
                veiculoProducer.enviarParaCadastro(veiculo);
            }catch (Exception e){
                logger.debug("Erro ao enviar veículo de placa: {}", veiculo.getPlaca());
                throw new RuntimeException(e.getMessage());
            }
        });
    }

    public void salvarVeiculo(VeiculoToDTO veiculoParaSalvar){
        try {

        }catch (Exception e){

        }
    }
}
