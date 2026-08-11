package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Contact;
import com.example.demo.repository.ContactRepository;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    // CREATE
    public Contact addContact(Contact contact) {
        return contactRepository.save(contact);
    }

    // READ ALL
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    // READ BY ID
    public Contact getContactById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    // UPDATE
    public Contact updateContact(Long id, Contact contact) {

        Contact existingContact = contactRepository.findById(id).orElse(null);

        if (existingContact != null) {

            existingContact.setFirstName(contact.getFirstName());
            existingContact.setLastName(contact.getLastName());
            existingContact.setPhone(contact.getPhone());
            existingContact.setAlternativePhone(contact.getAlternativePhone());
            existingContact.setEmail(contact.getEmail());

            return contactRepository.save(existingContact);
        }

        return null;
    }

    // DELETE
    public String deleteContact(Long id) {

        if (contactRepository.existsById(id)) {
            contactRepository.deleteById(id);
            return "Contact deleted successfully";
        }

        return "Contact not found";
    }
}