package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Contact;
import com.example.demo.service.ContactService;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    // CREATE
    @PostMapping
    public Contact addContact(@RequestBody Contact contact) {
        return contactService.addContact(contact);
    }

    // READ ALL
    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable Long id) {
        return contactService.getContactById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Contact updateContact(
            @PathVariable Long id,
            @RequestBody Contact contact) {

        return contactService.updateContact(id, contact);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteContact(@PathVariable Long id) {
        return contactService.deleteContact(id);
    }
}