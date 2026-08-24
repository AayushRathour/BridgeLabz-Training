package com.aayush.fundoo.notification;

import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.stereotype.Component;

@Component
// Converts a committed note event into the RabbitMQ message payload.
public class NoteCreatedEventListerner {
	
	private final RabbitMQProducer rabbitMQProducer;

	public NoteCreatedEventListerner(RabbitMQProducer rabbitMQProducer) {
		this.rabbitMQProducer = rabbitMQProducer;
	}
	// Runs only after the database transaction commits successfully.
	@TransactionalEventListener(phase =TransactionPhase.AFTER_COMMIT)
	public void handerNoteCreated(NoteCreatedEvent event) {
		NoteCreatedMessage message = new NoteCreatedMessage(
				event.getNoteId(),
				event.getTitel(),
				event.getUseremail());
		rabbitMQProducer.sendNoteCreatedMessage(message);
	}


}
