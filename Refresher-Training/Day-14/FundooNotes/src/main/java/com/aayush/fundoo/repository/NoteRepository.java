package com.aayush.fundoo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aayush.fundoo.entity.Note;

// Provides database queries for Note objects and their owner checks.
public interface NoteRepository extends JpaRepository<Note, Long> {
	Optional<Note> findByIdAndUserEmail(Long id, String email);

	// NEW FOR NOTE CRUD -- START
	List<Note> findAllByUserEmailOrderByIdDesc(String email);
	// NEW FOR NOTE CRUD -- END
}
