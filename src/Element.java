
public class Element {
	private String code, nom, unite;
	private int quantite, demande;
	private double prixAchat, prixVente;
	
	public Element(String code, String nom, int quantite, String unite) {
		this.code = code;
		this.nom = nom;
		this.quantite = quantite;
		this.unite = unite;
	}
	
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
	
	public String toString() {
		return "Element [code=" + this.code + ", nom=" + this.nom + ", quantité=" + quantite + ", unité=" + this.unite + "]";
	}
}
