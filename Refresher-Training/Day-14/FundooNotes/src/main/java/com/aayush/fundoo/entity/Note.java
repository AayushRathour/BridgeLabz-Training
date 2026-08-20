package com.aayush.fundoo.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="notes")
@Getter
@Setter
// Maps one note and its owning user to one row in the notes table.
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false, length = 150)
	private String title;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String content;

	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
	@JsonIgnore
    private User user;

	// Fills the existing database timestamps before a new note is inserted.
	@PrePersist
	private void setCreationTimes() {
		createdAt = LocalDateTime.now();
		updatedAt = createdAt;
	}

	// Refreshes the update timestamp whenever a note is changed.
	@PreUpdate
	private void setUpdateTime() {
		updatedAt = LocalDateTime.now();
	}

}
