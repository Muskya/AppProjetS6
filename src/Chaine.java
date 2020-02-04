import java.util.ArrayList;
import java.util.HashMap;

public class Chaine {
	
	private String code, nomChaine;
	private double temps;
	private int nivActivite;

	private HashMap<Element, Integer> entree;
	private HashMap<Element, Integer> sortie;
	
	
	public static ArrayList<Chaine> LesChaines = new ArrayList<Chaine>();
	//private ArrayList<Personnel> personnelQualifie; A impl�menter plus tard
	//private ArrayList<Personnel> personnelNonQualifie;

	/**
	 * 
	 * @param code
	 * @param nomChaine
	 * @param temps
	 * @param sortie Hashmap contenant UN SEUL �l�ment : la sortie de la chaine (element, quantit�)
	 * @param entree Hashmap contenant plusieurs �l�ments : les �l�ments en entr�e (element, quantit�)
	 */
	public Chaine (String code, String nomChaine, double temps, HashMap<Element, Integer> sortie,
			HashMap<Element, Integer> entree) {
		this.code=code;
		this.nomChaine=nomChaine;
		
		this.temps=temps;
	}
	
	/**
	 * M�thode permettant l'ex�cution de la production de la cha�ne courante.
	 */
	public void Production() {
		//Calculs en fonction de la demande, quantit�, temps.
	}
}
