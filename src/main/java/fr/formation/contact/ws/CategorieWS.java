package fr.formation.contact.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.contact.entity.Categorie;
import fr.formation.contact.service.CategorieException;
import fr.formation.contact.service.CategorieService;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/categorie")
public class CategorieWS {
	
	
	@Autowired
	CategorieService service;

	@PostConstruct
	public void init() {
		service.addCategorie(new Categorie("SUPER", "Super client"));
		service.addCategorie(new Categorie("MAUVAIS", "Mauvais client"));
		service.addCategorie(new Categorie("ETRANGE", "client étrange"));
	}
	
	@GetMapping
	public ResponseEntity<List<Categorie>> getAll(){
		List<Categorie> lst = service.getAllCategorie();
		return ResponseEntity.ok().body(lst);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Categorie> getById(@PathVariable("id") Integer id){
		Categorie cat = null;
		
		try {
			cat = service.getCategorieById(id);
		} catch (CategorieException e) {
			e.printStackTrace();
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(cat);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Integer id){
		service.delCategorieById(id);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping
	public ResponseEntity<Categorie> addCategorie(@RequestBody Categorie categorie) {
		service.addCategorie(categorie);
		return ResponseEntity.ok().body(categorie);
	}
	
	@PutMapping
	public ResponseEntity<Categorie> modCategorie(@RequestBody Categorie categorie) {
		service.modCategorie(categorie);
		return ResponseEntity.ok().body(categorie);
	}
	
}
