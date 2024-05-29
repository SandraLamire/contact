package fr.formation.contact.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.formation.contact.entity.Client;

public interface ClientRepository extends CrudRepository<Client, Integer>{

	@Query("SELECT c FROM Client c JOIN c.lstCategories cat WHERE cat.libelle=:categorie")
	List<Client> findAllFromCategorie(@Param("categorie") String categorie);

}
