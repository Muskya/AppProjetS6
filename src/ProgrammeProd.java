import java.util.ArrayList;

public class ProgrammeProd {
	private ArrayList<Chaine> chainesUtil;
	private double indicValeur;
	private double indicCommande;

	/**
	 * Constructeur de la classe ProgrammeProd
	 */
	public ProgrammeProd () {
		chainesUtil = new ArrayList<Chaine>(); //La liste des cha�nes utilis�es pour le programme de prod
		
		this.indicValeur=0;
		this.indicCommande=0;
	}
	
	/**
	 * Methode principale de cr�ation d'un programme de production hebdomadaire (sujet � �voluer)
	 */
	public void CreerProgramme() {
		System.out.println("---Cr�ation d'un programme de production---");
		//Scanner r�cup�rant les chaines que souhaite utiliser l'utilisateur pour le programme
		//ou r�cup�ration depuis la saisie dans l'interfacae graphique
	}
	
}
