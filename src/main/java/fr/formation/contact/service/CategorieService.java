package fr.formation.contact.service;

import java.util.List;

import fr.formation.contact.entity.Categorie;

public interface CategorieService {
	public List<Categorie> getAllCategorie();
	public Categorie getCategorieById(Integer id) throws CategorieException;
	public void addCategorie(Categorie categorie);
	public void modCategorie(Categorie categorie);
	public void delCategorie(Categorie categorie);
	public void delCategorieById(Integer id);
}
