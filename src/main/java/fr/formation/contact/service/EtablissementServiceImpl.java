package fr.formation.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.contact.entity.Etablissement;
import fr.formation.contact.repository.EtablissementRepository;

@Service
public class EtablissementServiceImpl implements EtablissementService {
	@Autowired
	EtablissementRepository repo;
	
	@Override
	public List<Etablissement> getAllEtablissements() {
		return (List<Etablissement>) repo.findAll();
	}

}
