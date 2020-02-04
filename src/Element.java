import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Element {
	private String code, nom, unite;
	private int quantiteStock, demande;
	private double prixAchat, prixVente;	
	
	//public static ArrayList<Element> lesElements = new ArrayList<Element>();
	public static HashMap<String, Element> LesElems = new HashMap<String, Element>();
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getQuantite() {
		return quantiteStock;
	}

	public void setQuantite(int quantite) {
		this.quantiteStock = quantite;
	}

	public Element(String code, String nom, int quantite, String unite) {
		this.code = code;
		this.nom = nom;	
		this.unite = unite;
		this.quantiteStock = quantite;
	}
	
	/**
	 * Constructeur principal de la classe Element. Utilisé notamment dans la classe DataLoad
	 * lors de l'instanciation de tous éléments de Elements.Csv
	 * @param code
	 * @param nom
	 * @param unite
	 * @param quantite
	 * @param demande
	 * @param prixAchat
	 * @param prixVente
	 */
	public Element(String code, String nom, String unite, int quantite, int demande,
			double prixAchat, double prixVente) {
		this.code = code;
		this.nom = nom;
		this.unite = unite;
		this.quantiteStock = quantite;
		this.demande = demande;
		this.prixAchat = prixAchat;
		this.prixVente = prixVente;
		
		//Utilisé dans la classe de chargement des données
	}
	
	/**
	 * Redéfinition de toString() pour décrire un élément courant.
	 */
	public String toString() {
		return "Element [code=" + this.code + ", nom=" + this.nom + ", quantité=" + quantiteStock + ", unité=" + this.unite + "]";
	}
}
