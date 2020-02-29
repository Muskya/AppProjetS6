import com.opencsv.*;
import java.io.*; //ioexception, reader
import java.nio.*; //files, paths
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

abstract public class DataLoad {
	
	static String csv_file; //Contient le chemin vers le .csv � charger
	static Path filePath; //Contient la r�f�rence de localisation du .csv
	static CSVParser parser; //D�finit le "pattern" de r�cup�ration des donn�es des .csv
	static BufferedReader br; 
	static CSVReader reader; //Lecture des donn�es des .Csv
	
	//Le main est dans cette classe, car la premi�re chose que fait le programme
	//est le chargement des donn�es. (sujet � changer lors de l'impl�mentation de l'interface
	//graphique
	public static void main(String[] args) throws IOException {
		
		try {
			parser = new CSVParserBuilder().withSeparator(';').build();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Appel des fonctions de chargement en pr�cisant les chemins des .Csv
		DataElements("C:\\Users\\Th�oRebbouh\\Documents\\WorkspaceEclipse\\AppProjetS6\\src\\elements.csv");
		DataChaines("C:\\Users\\Th�oRebbouh\\Documents\\WorkspaceEclipse\\AppProjetS6\\src\\chaines.csv");
	}
	
	/**
	 * M�thode DataElements permettant d'instancier autant d'�l�ments qu'il y a d'enregistrements
	 * dans le fichier elements.csv
	 * @param pathElementsCSV String
	 * @throws IOException 
	 */
	//R�cup�ration des donn�es d'elements.csv
	public static void DataElements(String pathElementsCSV) throws IOException {

		//Initialisation des diff�rents objets permettant la r�cup�ration des donn�es du .csv
		csv_file = pathElementsCSV;
		filePath = Paths.get(csv_file); 
		br = Files.newBufferedReader(filePath, Charset.forName("ISO-8859-1"));
		reader = new CSVReaderBuilder(br).withCSVParser(parser).withSkipLines(1).build();
				
		//System.out.println("---Chargement des donn�es des �l�ments (mati�res premi�res et produits)---");
		        	
		//Tableau NextLine pour chaque ligne lue du .csv
		String [] nextLine;
		//Tant qu'il y a une nouvelle ligne d'�l�ment dans le .csv
		while ((nextLine = reader.readNext()) != null) {
			
			//Affiche chaque ligne du .csv
//		    System.out.println("Cr�ation nouvel �l�ment avec pour valeurs :");
//		    System.out.println("Code: " + nextLine[0] + ", Nom: " + nextLine[1] 
//		        	 + ", Quantit�: " + nextLine[2] + ", Unit�: " + nextLine[3] + "\n");
		    
		    //Ajoute dans la HashMap statique lesElems de la classe Element les diff�rentes informations
		    //r�cup�r�es sur la ligne courante du .csv
		    Element.LesElems.put(nextLine[0], new Element
		        	 (nextLine[0], nextLine[1], Integer.parseInt(nextLine[2]), nextLine[3]));
		    //Integer.parseInt car les �l�ments de nextLine sont tous des String, et on a besoin
		    //d'un Int dans le constructeur pour la quantit�.
		}
		        	
//		System.out.println("Tous les �l�ments ont �t� charg�s.");
//		System.out.println("Les voici :");
//		for (Element e : Element.LesElems.values()) {
//			System.out.println(e.toString());
//		}
		
		//Contiendra plus tard les prixVente, prixAchat, demande, etc.
		            
	}
	
	/**
	 * Instanciation des diff�rentes chaines de chaines.csv
	 * @param pathChainesCSV
	 * @throws IOException
	 */
	public static void DataChaines(String pathChainesCSV) throws IOException {
		//Initialisation des diff�rents objets permettant la r�cup�ration des donn�es du .csv
		csv_file = pathChainesCSV;
		filePath = Paths.get(csv_file); 
		br = Files.newBufferedReader(filePath, Charset.forName("ISO-8859-1"));
		reader = new CSVReaderBuilder(br).withCSVParser(parser).withSkipLines(1) //SpipLines = skip l'en-t�te du .csv
                .build();
		
		HashMap<Element, Integer> elementQuantiteSortie = new HashMap<Element, Integer>();
		HashMap<Element, Integer> elementQuantiteEntree = new HashMap<Element, Integer>();
		String codeElementSortie;
		Integer quantiteElementSortie;
		
		//Vont accueillir les codes et quantit�s de chaque �l�ment en entr�e de cha�ne
		String[] codesElementsEntree;
		Integer[] quantitesElementsSortie;
		String codeElemEntree;
		Integer quantiteElemEntree;
		
		//R�cup�ration et traitement des donn�es
		System.out.println("---Chargement des donn�es des chaines---\n");
    	
		String [] nextLine;
		//Tant qu'il y a des lignes dans le .Csv
		while ((nextLine = reader.readNext()) != null) {
			
//			//Affiche chaque ligne du .csv	
//		    System.out.println("Cr�ation d'une nouvelle cha�ne :");
//		    System.out.println("Code: " + nextLine[0] + ", Nom: " + nextLine[1] 
//		        	 + ", Entr�e: " + nextLine[2] + ", Sortie: " + nextLine[3]
//		        	 + ", Temps: " + nextLine[4]);
//		    
//		    //Syop de test pour v�rifier le bon fonctionnement du substring/regex
//		    System.out.println("Code de l'�l�ment en sortie: " + nextLine[3].substring(1, 5));
//		    System.out.println("Quantit� de l'�l�ment en sortie: " + nextLine[3].substring(6, 7) + "\n");
		    
			//On split tout d'abord les �l�ments de la colonne 3 du .csv (les �l�ments en entr�e)
			codesElementsEntree = nextLine[2].split(",");
			for (String s : codesElementsEntree) { //Pour chaque valeur s�par�e par une virgule r�cup�r�e
				codeElemEntree = s.substring(1,5); //On prend les caract�res 2 � 4 (Exxx), le code
				quantiteElemEntree = Integer.parseInt(s.substring(5,6)); //On prend les caract�res 5 � 6 (xx), la quantit�
				for (Element e : Element.LesElems.values()) { //Si on trouve un �l�ment dans la liste des �l�ments existants
					//qui colle avec le code que l'on vient de r�cup�rer
					if (e.getCode().contentEquals(codeElemEntree)) { //On ajoute � la hashmap d'�l�ments en entr�e l'�l�ment courant
						elementQuantiteEntree.put(e, quantiteElemEntree);
					}
				}
			}
			
		    //R�cup�re le code de l'�l�ment en sortie en coupant les caract�res 1 � 5 (Cxxx)
	    	codeElementSortie = nextLine[3].substring(1, 5); //Peut aussi fonctionner avec le Regex \((.*?)\,
	    	//R�cup�re la quantit� produite de l'�l�ment en sortie en coupant les caract�res 6 � 7 
	    	quantiteElementSortie = Integer.parseInt(nextLine[3].substring(6,7));
		    
		    //Remplit la hashmap de l'�l�ment en sortie (Element, Quantit�) 
		    for (Element e : Element.LesElems.values()) { //On cherche dans la HashMap statique de tous les �l�ments
		    	if (e.getCode().equals(codeElementSortie)) { //Si le code d'un des �l�ments existant correspond, alors on l'ajoute
		    		elementQuantiteSortie.put(e, quantiteElementSortie);
		    	}
		    }
		    
		    //On ajoute le tout dans la ArrayList statique des cha�nes
		    Chaine.LesChaines.add(new Chaine(nextLine[0], nextLine[1], Double.parseDouble(nextLine[4]),
		    	elementQuantiteEntree, elementQuantiteSortie));

		} //Sortie de la boucle .nextLine()
		
		System.out.println("--- AFFICHAGE DE TOUTES LES CHAINES DEPUIS CHAINE.LESCHAINES ---");
		for (Chaine c : Chaine.LesChaines) {
	    	//System.out.println(c.toString());
	    }
		
	}
}
