package fr.formation.contact.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.contact.entity.Etablissement;
import fr.formation.contact.service.EtablissementService;

@RestController
@RequestMapping("etablissement")
public class EtablissementWS {
	@Autowired
	EtablissementService service;
	
	@GetMapping
	public List<EtablissementDTO> getAll(){
		List<EtablissementDTO> lst = new ArrayList<>();
		service.getAllEtablissements().forEach(e->lst.add(new EtablissementDTO(e)));
		return lst;
	}
}
