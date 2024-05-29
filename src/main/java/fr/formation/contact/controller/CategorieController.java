package fr.formation.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.contact.entity.Categorie;
import fr.formation.contact.service.CategorieService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/ihm/categorie")
public class CategorieController {
	@Autowired
	CategorieService service;
	
	@ModelAttribute("lstCategories")
	public List<Categorie> getAllCategories(){
		return service.getAllCategorie();
	}
	
	// @ModelAttribute pas nécessaire, par défaut nom de la classe avec une minuscule
	@GetMapping
	public String getAll(@ModelAttribute("categorie") Categorie categorie) {
		return "categorie";
	}
	
	@PostMapping
	public String valid(@Valid @ModelAttribute("categorie") Categorie categorie, BindingResult errors) {
		if(errors.hasErrors()) {
			return "categorie";
		}
		service.addCategorie(categorie);
		return "redirect:/ihm/categorie";
	}
	

}
