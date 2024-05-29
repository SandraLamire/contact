package fr.formation.contact.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.formation.contact.entity.Contact;
import jakarta.transaction.Transactional;

@SpringBootTest
class ContactServiceImplTest {
	@Autowired
	ContactService service;
	
	@Test
	@Transactional
	void addContactTest() throws ContactException {
		Contact jean = Contact.builder()
					.nom("Cérien")
					.prenom("Jean")
					.tel("156565665").build();
		service.addContact(jean);
		assertNotNull(jean.getIdContact());
	}
	
	@Test
	@Transactional
	void addContactTestContrainteMartin() throws ContactException {
		Contact jean = Contact.builder()
				.nom("Martin")
				.prenom("Jean")
				.tel("156565665").build();
		assertThrows(ContactException.class, ()->{
			service.addContact(jean);
		});
		assertNull(jean.getIdContact());
	}
	
	@Test
	@Transactional
	void getAllTest() throws ContactException {
		// je considère que je pars d'une BDD vide
		Contact jean = Contact.builder()
				.nom("Cérien")
				.prenom("Jean")
				.tel("156565665").build();
		Contact vincent = Contact.builder()
				.nom("Tim")
				.prenom("Vincent")
				.tel("156565665").build();
		service.addContact(vincent);
		service.addContact(jean);
		
		List<Contact> lst = service.getAll();
		assertEquals(lst.size(), 2);
	}
	
	@Test
	@Transactional
	void getFromNomAndPrenomTest() throws ContactException {
		Contact jean = Contact.builder()
				.nom("Cérien")
				.prenom("Jean")
				.tel("156565665").build();
		Contact vincent = Contact.builder()
				.nom("Tim")
				.prenom("Vincent")
				.tel("156565665").build();
		service.addContact(vincent);
		service.addContact(jean);
		
		List<Contact> lst = service.getFromNomAndPrenom("Cérien", "Jean");
		
		assertTrue(lst.size()>0);
	}
	
	@Test
	@Transactional
	void bug02447() {
		Contact jean = Contact.builder()
				.nom("MARTIN")
				.prenom("Jean")
				.tel("156565665").build();
		assertThrows(ContactException.class, ()->{
			service.addContact(jean);
		});
		assertNull(jean.getIdContact());
	}

}
