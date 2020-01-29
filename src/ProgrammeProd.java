import java.util.ArrayList;

public class ProgrammeProd {
	private ArrayList<Chaine> chainesUtil;
	private double indicValeur;
	private double indicCommande;

	public ProgrammeProd () {
		chainesUtil = new ArrayList<Chaine>();
		
		this.indicValeur=0;
		this.indicCommande=0;
	}
	
	public void CreerProgramme() {
		//Sera remplacé par des données de chaînes déjà connues
		for (int i = 0; i < 5; i++) {
			Chaine c = new Chaine("E060", "iPhone", new Element("E010", "Sucre", "g", 100, 2, 5, 3), 10);
			chainesUtil.add(c);
		}

	}
	
}
