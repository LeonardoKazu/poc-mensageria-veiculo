package com.leonardokazu.poc_mensageria_docker.service;

import com.leonardokazu.poc_mensageria_docker.config.VeiculoRabbitMQConfig;
import com.leonardokazu.poc_mensageria_docker.model.VeiculoToDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class VeiculoListener {

    private static final Logger logger = LoggerFactory.getLogger(VeiculoListener.class);
    private final VeiculoService veiculoService;

    public VeiculoListener(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @RabbitListener(queues = VeiculoRabbitMQConfig.QUEUE_VEICULO)
    public void processarCadastroVeiculo(VeiculoToDTO veiculo) throws InterruptedException {
        logger.info("[CONSUMER] Mensagem recebida da fila: {}, recebida em {}", veiculo, java.time.LocalTime.now());
        logger.info("[CONSUMER] Sleep de thread(5 segundos) simulando processamento pesado...");
        Thread.sleep(5000);
        logger.info("[CONSUMER] Processamento concluído em: {}", java.time.LocalTime.now());
    }
}
