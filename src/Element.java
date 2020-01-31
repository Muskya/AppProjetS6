import java.io.IOException;
import java.util.ArrayList;

public class Element {
	private String code, nom, unite;
	private int quantite, demande;
	private double prixAchat, prixVente;	
	
	public static ArrayList<Element> lesElements = new ArrayList<Element>();
	
	public Element(String code, String nom, int quantite, String unite) {
		this.code = code;
		this.nom = nom;
		this.unite = unite;
		this.quantite = quantite;
	}
	
	public Element(String code, String nom, String unite, int quantite, int demande,
			double prixAchat, double prixVente) {
		this.code = code;
		this.nom = nom;
		this.unite = unite;
		this.quantite = quantite;
		this.demande = demande;
		this.prixAchat = prixAchat;
		this.prixVente = prixVente;
		
		//Utilis� dans la classe de chargement des donn�es
	}
	
	public String toString() {
		return "Element [code=" + this.code + ", nom=" + this.nom + ", quantit�=" + quantite + ", unit�=" + this.unite + "]";
	}
}
