package fr.formation.contact.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Contact {
	@Id
	@GeneratedValue
	private Integer idContact;
	private String nom;
	private String prenom;
	private String tel;
	
	//@ManyToOne(cascade = CascadeType.ALL)
	//@ManyToOne(fetch = FetchType.EAGER)
	@ManyToOne
	private Client client;
	
	public Contact(String nom, String prenom, String tel) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
	}
	
	
}
