package fr.formation.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.contact.entity.Contact;
import fr.formation.contact.repository.ClientRepository;
import fr.formation.contact.repository.ContactRepository;
import fr.formation.contact.repository.EtablissementRepository;
import fr.formation.contact.repository.MaisonMereRepository;
import jakarta.transaction.Transactional;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	ContactRepository repoContact;

	@Autowired
	ClientRepository repoClient;
	
	@Autowired
	EtablissementRepository repoEtablissement;

	@Autowired
	MaisonMereRepository repoMaisonMere;


	
	@Override
	@Transactional
	public void addContact(Contact contact) throws ContactException {
		if("MARTIN".equals(contact.getNom().toUpperCase())){
			throw new ContactException("Pas de Martin!!!");
		}
		if(contact.getClient()!=null) {
			repoMaisonMere.save(contact.getClient().getMaisonMere());
			contact.getClient().getLstEtablissements().forEach(e->repoEtablissement.save(e));
			repoClient.save(contact.getClient());
		}
		repoContact.save(contact);
	}

	@Override
	public List<Contact> getAll() {
		return (List<Contact>) repoContact.findAll();
	}

	@Override
	public List<Contact> getFromNomAndPrenom(String nom, String prenom) {
		return repoContact.findAllByNomAndPrenom(nom, prenom);
	}

}
