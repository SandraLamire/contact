package fr.formation.contact.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Etablissement {
	@Id
	@GeneratedValue
	private Integer idEtablissement;
	private String nom;
	private String adresse;
	private Integer effectif;
	@ManyToOne
	@ToString.Exclude
	private Client client;

	public Etablissement(String nom, String adresse, Integer effectif) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.effectif = effectif;
	}

}
