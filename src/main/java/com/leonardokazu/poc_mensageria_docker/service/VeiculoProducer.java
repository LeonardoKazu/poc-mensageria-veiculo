package com.leonardokazu.poc_mensageria_docker.service;

import com.leonardokazu.poc_mensageria_docker.config.VeiculoRabbitMQConfig;
import com.leonardokazu.poc_mensageria_docker.model.Veiculo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class VeiculoProducer {

    private static final Logger logger = LoggerFactory.getLogger(VeiculoProducer.class);
    private final RabbitTemplate rabbitTemplate;

    public VeiculoProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarParaCadastro(Veiculo veiculoDto) {
        logger.info("[PRODUCER] Enviando veículo com routing key: {}, em {}", VeiculoRabbitMQConfig.ROUTING_KEY_CADASTRAR_VEICULO, java.time.LocalTime.now());
        rabbitTemplate.convertAndSend(
                VeiculoRabbitMQConfig.EXCHANGE_VEICULO,
                VeiculoRabbitMQConfig.ROUTING_KEY_CADASTRAR_VEICULO,
                veiculoDto
        );
        logger.info("[PRODUCER] Mensagem enviada com sucesso!");
    }
}
