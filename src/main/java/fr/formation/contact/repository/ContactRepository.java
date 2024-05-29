package fr.formation.contact.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.formation.contact.entity.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer>{

	List<Contact> findAllByNomAndPrenom(String nom, String prenom);

	@Query("SELECT c FROM Contact c WHERE c.nom= :nom AND c.prenom= :prenom")
	List<Contact> findTel(@Param("nom")String nom, @Param("prenom")String prenom);

	@Query("SELECT c.tel FROM Contact c WHERE c.client.ville=:ville")
	List<String> getTelContactOfClientInVille(@Param("ville") String ville);

	@Query("SELECT c.client.ville FROM Contact c WHERE c.tel=:tel")
	List<String> getVilleClientOfContactTel(@Param("tel") String tel);
}
