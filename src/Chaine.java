import java.util.ArrayList;
import java.util.HashMap;

public class Chaine {
	
	private String code, nomChaine;
	private double temps;
	private int nivActivite;

	private HashMap<Element, Integer> entree;
	private HashMap<Element, Integer> sortie;
	
	public static ArrayList<Chaine> LesChaines = new ArrayList<Chaine>();
	//private ArrayList<Personnel> personnelQualifie; A implémenter plus tard
	//private ArrayList<Personnel> personnelNonQualifie;

	/**
	 * 
	 * @param code
	 * @param nomChaine
	 * @param temps
	 * @param sortie Hashmap contenant UN SEUL élément : la sortie de la chaine (element, quantité)
	 * @param entree Hashmap contenant plusieurs éléments : les éléments en entrée (element, quantité)
	 */
	public Chaine (String code, String nomChaine, double temps, HashMap<Element, Integer> entree,
			HashMap<Element, Integer> sortie) {
		this.code=code;
		this.nomChaine=nomChaine;
		this.temps=temps;
		this.entree = entree;
		this.sortie = sortie;
	}
	
	/**
	 * Méthode permettant l'exécution de la production de la chaîne courante.
	 */
	public void Production() {
		//Calculs en fonction de la demande, quantité, temps.
	}
	
	public String toString() {
		
		String elementsEntree = "";
		for (Element e : this.entree.keySet()) {
			elementsEntree += "nique ta mere";
		}
		
		String elementsSortie = "";
		for (Element e : this.sortie.keySet()) {
			elementsSortie += "- " + e.toString() + "\n";
		}
		
		return "Code: " + this.code + ", Nom: " + this.nomChaine + "\n"
				+ "----- Liste des éléments en entrée ----- \n" 
				+ elementsEntree
				+ "----- Liste des éléments en sortie ----- \n"
				+ elementsSortie
				;
	}
}
