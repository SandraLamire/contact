package fr.formation.contact.ws;

import fr.formation.contact.entity.Etablissement;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EtablissementDTO {
	private Integer idEtablissement;
	private String nom;
	private String adresse;
	private String nomClient;
	
	public EtablissementDTO(Etablissement etablissement) {
		this.idEtablissement=etablissement.getIdEtablissement();
		this.nom=etablissement.getNom();
		this.adresse=etablissement.getAdresse();
		this.nomClient = etablissement.getClient().getNom();
	}
	
	public Etablissement toEntity() {
		Etablissement et = new Etablissement();
		et.setIdEtablissement(idEtablissement);
		et.setNom(nom);
		et.setAdresse(adresse);
		return et;
	}
}
