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
	public Chaine (String code, String nomChaine, double temps, HashMap<Element, Integer> sortie,
			HashMap<Element, Integer> entree) {
		this.code=code;
		this.nomChaine=nomChaine;
		
		this.temps=temps;
	}
	
	/**
	 * Méthode permettant l'exécution de la production de la chaîne courante.
	 */
	public void Production() {
		//Calculs en fonction de la demande, quantité, temps.
	}
}
