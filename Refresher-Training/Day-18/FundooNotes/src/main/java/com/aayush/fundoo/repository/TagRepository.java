package com.aayush.fundoo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aayush.fundoo.entity.Tag;
import com.aayush.fundoo.entity.User;

public interface TagRepository extends JpaRepository<Tag, Long> {

    // Finds a tag only when it belongs to the logged-in user.
    Optional<Tag> findByNameIgnoreCaseAndUser(
            String name,
            User user
    );

    // Finds a tag by ID only when it belongs to the logged-in user.
    Optional<Tag> findByIdAndUser(
            Long id,
            User user
    );

    // Lists every tag/label the logged-in user has created, A to Z.
    List<Tag> findAllByUserOrderByNameAsc(User user);
}