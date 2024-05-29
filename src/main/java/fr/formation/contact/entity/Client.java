package fr.formation.contact.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Client {
	@Id
	@GeneratedValue
	private Integer idClient;
	
	@Column(name = "name",length = 25)
	private String nom;
	private String adresse;
	private String ville;
	@OneToMany(mappedBy = "client")
	private List<Etablissement> lstEtablissements = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name = "id_maison_mere")
	private MaisonMere maisonMere;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Categorie> lstCategories = new ArrayList<>();
	
	
	public Client(String nom, String adresse, String ville) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;
	}
	
	public void addEtablissement(Etablissement etablissement) {
		lstEtablissements.add(etablissement);
		etablissement.setClient(this);
	}
	
}
