package com.aayush.fundoo.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tags")
@Getter 
@Setter
// Only "id" decides equality so a tag fetched twice from the DB still
// matches correctly when added to / removed from a note's tag Set.
@EqualsAndHashCode(of = "id")
public class Tag {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	// Owner of this tag. Hidden from JSON so a note's tags never leak the
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	@JsonIgnore
	private User user;
	
	// Back-reference to every note using this tag. Hidden from JSON, otherwise
	@ManyToMany(mappedBy = "tags")
	@JsonIgnore
	private Set<Note> notes = new HashSet<>();
	
	
	
	
}
