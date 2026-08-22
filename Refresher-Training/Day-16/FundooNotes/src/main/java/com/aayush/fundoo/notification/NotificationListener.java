package com.aayush.fundoo.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
// Consumes reminder messages in the background, completely independent of
// the request/scheduler run that originally queued them. In production this
// method would call an email or push-notification provider; here it logs a
// clearly formatted line to simulate delivery, which is enough to prove the
// async flow works end to end.
public class NotificationListener {

	private static final Logger log = LoggerFactory.getLogger(NotificationListener.class);

	@JmsListener(destination = "${app.notifications.reminder-queue}")
	public void handleReminder(ReminderMessage message) {
		log.info("REMINDER for {} -> \"{}\" (note #{}) was due at {}",
				message.getUserEmail(),
				message.getNoteTitle(),
				message.getNoteId(),
				message.getReminderAt());
	}
}
