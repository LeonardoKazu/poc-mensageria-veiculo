package com.leonardokazu.poc_mensageria_docker.service;

import com.leonardokazu.poc_mensageria_docker.VeiculoRepository;
import com.leonardokazu.poc_mensageria_docker.model.VeiculoRequest;
import com.leonardokazu.poc_mensageria_docker.model.Veiculo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
            Veiculo veiculo = new Veiculo();
            veiculo.setPlaca(veiculoRequest.getPlaca());
            veiculo.setModelo(veiculoRequest.getModelo());
            veiculo.setCategoria(veiculoRequest.getCategoria());
            try {
                veiculoProducer.enviarParaCadastro(veiculo);
            }catch (Exception e){
                logger.debug("Erro ao enviar veículo de placa: {}", veiculo.getPlaca());
                throw new RuntimeException(e.getMessage());
            }
        });
    }

    public void salvarVeiculo(Veiculo veiculoToSave){
        try {
            veiculoToSave.setCriadoEm(LocalDateTime.now());
            veiculoRepository.save(veiculoToSave);
        }catch (Exception e){
            logger.debug("Erro ao salvar veículo de placa: {}", veiculoToSave.getPlaca());
            throw new RuntimeException(e.getMessage());
        }
    }
}
