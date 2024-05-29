package fr.formation.contact.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class MaisonMere {
	
	@Id
	@GeneratedValue
	public Integer idMaisonMere;
	public String adresse;
	public Integer effectif;
	public MaisonMere(String adresse, Integer effectif) {
		super();
		this.adresse = adresse;
		this.effectif = effectif;
	}
	
	
}
