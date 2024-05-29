package fr.formation.contact.service;

import java.util.List;

import fr.formation.contact.entity.Contact;

public interface ContactService {
	public void addContact(Contact contact) throws ContactException;
	public List<Contact> getAll();
	public List<Contact> getFromNomAndPrenom(String nom, String prenom);
}
