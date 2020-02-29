import java.util.ArrayList;

public class ProgrammeProd {
	private ArrayList<Chaine> chainesUtil;
	private double indicValeur;
	private double indicCommande;

	/**
	 * Constructeur de la classe ProgrammeProd
	 */
	public ProgrammeProd () {
		chainesUtil = new ArrayList<Chaine>(); //La liste des chaînes utilisées pour le programme de prod
		
		this.indicValeur=0;
		this.indicCommande=0;
	}
	
	/**
	 * Methode principale de création d'un programme de production hebdomadaire (sujet à évoluer)
	 */
	public void CreerProgramme() {
		System.out.println("---Création d'un programme de production---");
		//Scanner récupérant les chaines que souhaite utiliser l'utilisateur pour le programme
		//ou récupération depuis la saisie dans l'interfacae graphique
	}
	
}
