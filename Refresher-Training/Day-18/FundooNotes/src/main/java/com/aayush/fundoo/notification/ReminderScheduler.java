package com.aayush.fundoo.notification;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.aayush.fundoo.entity.Note;
import com.aayush.fundoo.repository.NoteRepository;

@Component
// Polls the database once a minute for reminders that have just come due,
// then hands each one to the JMS queue instead of notifying synchronously.
// This is the "asynchronous, non-blocking background processing" pattern:
// the polling loop never waits on email/push delivery.
public class ReminderScheduler {

	private final NoteRepository noteRepository;
	private final NotificationProducer notificationProducer;

	public ReminderScheduler(NoteRepository noteRepository, NotificationProducer notificationProducer) {
		this.noteRepository = noteRepository;
		this.notificationProducer = notificationProducer;
	}

	// Runs every 60 seconds. fixedRate means "60s between the start of one run
	// and the start of the next", regardless of how long each run takes.
	@Scheduled(fixedRate = 60000)
	@Transactional
	public void dispatchDueReminders() {
		List<Note> dueNotes = noteRepository.findByReminderAtLessThanEqualAndReminderSentFalse(LocalDateTime.now());

		for (Note note : dueNotes) {
			ReminderMessage message = new ReminderMessage(
					note.getId(),
					note.getTitle(),
					note.getUser().getEmail(),
					note.getReminderAt());

			notificationProducer.sendReminder(message); // non-blocking hand-off to the queue

			note.setReminderSent(true); // saved automatically at commit (dirty checking)
		}
	}
}
