package com.aayush.greetings.service;

import com.aayush.greetings.model.Greeting;
import com.aayush.greetings.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    public List<Greeting> list(int userId) {
        return greetingRepository.findByUserId(userId);
    }

    public Greeting get(int id, int userId) {
        return greetingRepository.findById(id, userId);
    }

    public void add(Greeting greeting) {
        validate(greeting);
        greetingRepository.save(greeting);
    }

    public void update(Greeting greeting) {
        validate(greeting);
        greetingRepository.update(greeting);
    }

    public void delete(int id, int userId) {
        greetingRepository.delete(id, userId);
    }

    private void validate(Greeting greeting) {
        if (greeting.getName() == null || greeting.getName().isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }
}
