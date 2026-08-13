package com.example.demo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.entity.Contact;
import com.example.demo.exception.ContactNotFoundException;
import com.example.demo.repository.ContactRepository;
import com.example.demo.service.ContactService;

@ExtendWith(MockitoExtension.class)
public class ContactServiceTest {
	
	@Mock
	private ContactRepository contactRepository;
	
	@InjectMocks
	private ContactService contactService;
	
	@Test
	void addContactTest() {

        Contact contact = new Contact();

        contact.setFirstName("Aayush");
        contact.setLastName("Rathour");
        contact.setPhone("9999999999");
        contact.setAlternativePhone("8888888888");
        contact.setEmail("aayush@gmail.com");

        when(contactRepository.save(contact))
                .thenReturn(contact);

        Contact result = contactService.addContact(contact);

        assertEquals("Aayush", result.getFirstName());
        assertEquals("Rathour", result.getLastName());

        verify(contactRepository).save(contact);
    }
	
	  @Test
	    void getAllContactsTest() {

	        Contact contact = new Contact();

	        contact.setFirstName("Aayush");
	        contact.setLastName("Rathour");

	        // Mock repository response
	        when(contactRepository.findAll())
	                .thenReturn(List.of(contact));

	        List<Contact> result = contactService.getAllContacts();

	        assertEquals(1, result.size());
	        assertEquals("Aayush", result.get(0).getFirstName());

	        verify(contactRepository).findAll();
	    }
	  @Test
	    void getContactByIdTest() {

	        Contact contact = new Contact();

	        contact.setFirstName("Aayush");
	        contact.setLastName("Rathour");

	        // Return a contact when ID 1 is requested
	        when(contactRepository.findById(1L))
	                .thenReturn(Optional.of(contact));

	        Contact result = contactService.getContactById(1L);

	        assertEquals("Aayush", result.getFirstName());

	        verify(contactRepository).findById(1L);
	    }
	
	
	

}
