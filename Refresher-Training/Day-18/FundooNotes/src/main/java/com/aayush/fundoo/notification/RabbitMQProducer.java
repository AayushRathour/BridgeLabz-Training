package com.aayush.fundoo.notification;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
// Publishes note-created payloads to the configured RabbitMQ exchange.
public class RabbitMQProducer {
	private final RabbitTemplate rabbitTemplate;
	@Value("${app.rabbitmq.exchange}")
	private String exchangeName;
	
	@Value("${app.rabbitmq.routing-key}")
	private String routingKey;

	public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
		super();
		this.rabbitTemplate = rabbitTemplate;
	}
	
	// Sends the message using the exchange and routing key configured for this application.
	public void sendNoteCreatedMessage(NoteCreatedMessage message) {
		rabbitTemplate.convertAndSend(
				exchangeName,
				routingKey,
				message);
	}

}
