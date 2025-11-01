package com.leonardokazu.poc_mensageria_docker.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VeiculoRabbitMQConfig {
    public static final String EXCHANGE_VEICULO = "veiculo";
    public static final String ROUTING_KEY_CADASTRAR_VEICULO = "cadastrar.veiculo";
    public static final String QUEUE_VEICULO = "cadastrar.veiculo.queue";

    @Bean
    public DirectExchange veiculoExchange(){
        return new DirectExchange(EXCHANGE_VEICULO);
    }

    @Bean
    public Queue veiculoQueue(){
        return new Queue(QUEUE_VEICULO, true);
    }

    @Bean
    public Binding bindVeiculo(){
        return BindingBuilder.bind(veiculoQueue()).to(veiculoExchange()).with(ROUTING_KEY_CADASTRAR_VEICULO);
    }

    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

}

