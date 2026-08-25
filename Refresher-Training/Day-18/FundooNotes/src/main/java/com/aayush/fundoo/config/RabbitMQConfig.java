package com.aayush.fundoo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// Declares the exchange, queue, binding, and JSON converter used by RabbitMQ.
public class RabbitMQConfig {

    @Value("${app.rabbitmq.exchange}")
    private String exchangeName;

    @Value("${app.rabbitmq.queue}")
    private String queueName;

    @Value("${app.rabbitmq.routing-key}")
    private String routingKey;


    // Creates the RabbitMQ exchange.
    @Bean
    public TopicExchange fundooExchange() {

        return new TopicExchange(exchangeName);
    }


    // Creates the queue where messages will wait.
    @Bean
    public Queue noteCreatedQueue() {

        return new Queue(queueName, true);
    }


    // Connects the queue to the exchange using routing key.
    @Bean
    public Binding noteCreatedBinding(
            Queue noteCreatedQueue,
            TopicExchange fundooExchange) {

        return BindingBuilder
                .bind(noteCreatedQueue)
                .to(fundooExchange)
                .with(routingKey);
    }
    
    @Bean
    public MessageConverter messageConverter() {
        // Serializes note-created payloads as JSON for RabbitMQ consumers.
        return new Jackson2JsonMessageConverter();
    }
}
