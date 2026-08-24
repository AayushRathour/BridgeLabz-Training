package com.aayush.fundoo.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
// Listens for note-created messages after RabbitMQ routes them to the queue.
public class RabbitMQConsumer {

	private static final Logger log = LoggerFactory.getLogger(RabbitMQConsumer.class);
	
	
	// Consumes note-created messages asynchronously.
	@RabbitListener(queues = "${app.rabbitmq.queue}")
	public void handelNoteCreated(
			NoteCreatedMessage message) {
		log.info("RabbitMQ Message Recieved ->>"+ "Note ID {}, Titel {}, User {}",
				message.getNoteId(), message.getTitel(), message.getUserEmail());
	}
}
