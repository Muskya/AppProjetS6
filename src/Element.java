
public class Element {
	private String code, nom, unite;
	private int quantite, demande;
	private double prixAchat, prixVente;
	
	public Element(String code, String nom, String unite, int quantite, int demande, double prixAchat, double prixVente) {
		this.code = code;
		this.nom = nom;
		this.unite = unite;
		this.quantite = quantite;
		this.demande = demande;
		this.prixAchat = prixAchat;
		this.prixVente = prixVente;
		
		//Utilisé dans la classe de chargement des données
	}
}
