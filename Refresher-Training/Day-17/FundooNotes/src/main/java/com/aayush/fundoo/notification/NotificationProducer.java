package com.aayush.fundoo.notification;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
// Publishes reminder messages onto the JMS queue and returns immediately.
// The caller never waits for the notification to actually be delivered -
// that happens later, asynchronously, in NotificationListener.
public class NotificationProducer {

	private final JmsTemplate jmsTemplate;

	@Value("${app.notifications.reminder-queue}")
	private String reminderQueue;

	public NotificationProducer(JmsTemplate jmsTemplate) {
		// Spring Boot auto-configures this bean once spring-boot-starter-artemis is on the classpath.
		this.jmsTemplate = jmsTemplate;
	}

	// Fire-and-forget: hands the message to the broker and does not block.
	public void sendReminder(ReminderMessage message) {
		jmsTemplate.convertAndSend(reminderQueue, message);
	}
}
