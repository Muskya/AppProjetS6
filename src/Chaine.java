import java.util.ArrayList;

public class Chaine {
	private String code;
	private String nomChaine;
	private ArrayList<Element> entree;
	private Element sortie;
	private double temps;
	private int nivActivite;
	//private ArrayList<Personnel> personnelQualifie; A implémenter plus tard
	//private ArrayList<Personnel> personnelNonQualifie;

	public Chaine(String code, String nomChaine, Element sortie,double temps) {
		this.code=code;
		this.nomChaine=nomChaine;
		this.sortie=sortie;
		this.temps=temps;
	}
	
	public void Production() {
		
	}
}
