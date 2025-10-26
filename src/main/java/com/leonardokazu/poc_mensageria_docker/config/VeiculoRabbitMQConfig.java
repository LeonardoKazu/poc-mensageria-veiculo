package com.leonardokazu.poc_mensageria_docker.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VeiculoRabbitMQConfig {
    public static final String EXCHANGE_VEICULOS = "veiculo";
    public static final String ROUTING_KEY_VEICULOS = "cadastrar.veiculo";
    public static final String QUEUE_VEICULOS = "cadastrar.veiculo.queue";

    @Bean
    public DirectExchange veiculoExchange(){
        return new DirectExchange(EXCHANGE_VEICULOS);
    }

    @Bean
    public Queue veiculoQueue(){
        return new Queue(QUEUE_VEICULOS, true);
    }

    @Bean
    public Binding bindVeiculo(){
        return BindingBuilder.bind(veiculoQueue()).to(veiculoExchange()).with(ROUTING_KEY_VEICULOS);
    }

}

