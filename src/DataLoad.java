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
	
	static String csv_file; //Contient le chemin vers le .csv à charger
	static Path filePath; //Contient la référence de localisation du .csv
	static CSVParser parser; //Définit le "pattern" de récupération des données des .csv
	static BufferedReader br; 
	static CSVReader reader; //Lecture des données des .Csv
	
	//Le main est dans cette classe, car la première chose que fait le programme
	//est le chargement des données. (sujet à changer lors de l'implémentation de l'interface
	//graphique
	public static void main(String[] args) throws IOException {
		
		try {
			parser = new CSVParserBuilder().withSeparator(';').build();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Appel des fonctions de chargement en précisant les chemins des .Csv
		DataElements("C:\\Users\\ThéoRebbouh\\Documents\\WorkspaceEclipse\\AppProjetS6\\src\\elements.csv");
		DataChaines("C:\\Users\\ThéoRebbouh\\Documents\\WorkspaceEclipse\\AppProjetS6\\src\\chaines.csv");
	}
	
	/**
	 * Méthode DataElements permettant d'instancier autant d'éléments qu'il y a d'enregistrements
	 * dans le fichier elements.csv
	 * @param pathElementsCSV String
	 * @throws IOException 
	 */
	//Récupération des données d'elements.csv
	public static void DataElements(String pathElementsCSV) throws IOException {

		//Initialisation des différents objets permettant la récupération des données du .csv
		csv_file = pathElementsCSV;
		filePath = Paths.get(csv_file); 
		br = Files.newBufferedReader(filePath, Charset.forName("ISO-8859-1"));
		reader = new CSVReaderBuilder(br).withCSVParser(parser).withSkipLines(1).build();
				
		//System.out.println("---Chargement des données des éléments (matières premières et produits)---");
		        	
		//Tableau NextLine pour chaque ligne lue du .csv
		String [] nextLine;
		//Tant qu'il y a une nouvelle ligne d'élément dans le .csv
		while ((nextLine = reader.readNext()) != null) {
			
			//Affiche chaque ligne du .csv
//		    System.out.println("Création nouvel élément avec pour valeurs :");
//		    System.out.println("Code: " + nextLine[0] + ", Nom: " + nextLine[1] 
//		        	 + ", Quantité: " + nextLine[2] + ", Unité: " + nextLine[3] + "\n");
		    
		    //Ajoute dans la HashMap statique lesElems de la classe Element les différentes informations
		    //récupérées sur la ligne courante du .csv
		    Element.LesElems.put(nextLine[0], new Element
		        	 (nextLine[0], nextLine[1], Integer.parseInt(nextLine[2]), nextLine[3]));
		    //Integer.parseInt car les éléments de nextLine sont tous des String, et on a besoin
		    //d'un Int dans le constructeur pour la quantité.
		}
		        	
//		System.out.println("Tous les éléments ont été chargés.");
//		System.out.println("Les voici :");
//		for (Element e : Element.LesElems.values()) {
//			System.out.println(e.toString());
//		}
		
		//Contiendra plus tard les prixVente, prixAchat, demande, etc.
		            
	}
	
	/**
	 * Instanciation des différentes chaines de chaines.csv
	 * @param pathChainesCSV
	 * @throws IOException
	 */
	public static void DataChaines(String pathChainesCSV) throws IOException {
		//Initialisation des différents objets permettant la récupération des données du .csv
		csv_file = pathChainesCSV;
		filePath = Paths.get(csv_file); 
		br = Files.newBufferedReader(filePath, Charset.forName("ISO-8859-1"));
		reader = new CSVReaderBuilder(br).withCSVParser(parser).withSkipLines(1) //SpipLines = skip l'en-tête du .csv
                .build();
		
		HashMap<Element, Integer> elementQuantiteSortie = new HashMap<Element, Integer>();
		HashMap<Element, Integer> elementQuantiteEntree = new HashMap<Element, Integer>();
		String codeElementSortie;
		Integer quantiteElementSortie;
		
		//Vont accueillir les codes et quantités de chaque élément en entrée de chaîne
		String[] codesElementsEntree;
		Integer[] quantitesElementsSortie;
		String codeElemEntree;
		Integer quantiteElemEntree;
		
		//Récupération et traitement des données
		System.out.println("---Chargement des données des chaines---\n");
    	
		String [] nextLine;
		//Tant qu'il y a des lignes dans le .Csv
		while ((nextLine = reader.readNext()) != null) {
			
//			//Affiche chaque ligne du .csv	
//		    System.out.println("Création d'une nouvelle chaîne :");
//		    System.out.println("Code: " + nextLine[0] + ", Nom: " + nextLine[1] 
//		        	 + ", Entrée: " + nextLine[2] + ", Sortie: " + nextLine[3]
//		        	 + ", Temps: " + nextLine[4]);
//		    
//		    //Syop de test pour vérifier le bon fonctionnement du substring/regex
//		    System.out.println("Code de l'élément en sortie: " + nextLine[3].substring(1, 5));
//		    System.out.println("Quantité de l'élément en sortie: " + nextLine[3].substring(6, 7) + "\n");
		    
			//On split tout d'abord les éléments de la colonne 3 du .csv (les éléments en entrée)
			codesElementsEntree = nextLine[2].split(",");
			for (String s : codesElementsEntree) { //Pour chaque valeur séparée par une virgule récupérée
				codeElemEntree = s.substring(1,5); //On prend les caractères 2 à 4 (Exxx), le code
				quantiteElemEntree = Integer.parseInt(s.substring(5,6)); //On prend les caractères 5 à 6 (xx), la quantité
				for (Element e : Element.LesElems.values()) { //Si on trouve un élément dans la liste des éléments existants
					//qui colle avec le code que l'on vient de récupérer
					if (e.getCode().contentEquals(codeElemEntree)) { //On ajoute à la hashmap d'éléments en entrée l'élément courant
						elementQuantiteEntree.put(e, quantiteElemEntree);
					}
				}
			}
			
		    //Récupère le code de l'élément en sortie en coupant les caractères 1 à 5 (Cxxx)
	    	codeElementSortie = nextLine[3].substring(1, 5); //Peut aussi fonctionner avec le Regex \((.*?)\,
	    	//Récupère la quantité produite de l'élément en sortie en coupant les caractères 6 à 7 
	    	quantiteElementSortie = Integer.parseInt(nextLine[3].substring(6,7));
		    
		    //Remplit la hashmap de l'élément en sortie (Element, Quantité) 
		    for (Element e : Element.LesElems.values()) { //On cherche dans la HashMap statique de tous les éléments
		    	if (e.getCode().equals(codeElementSortie)) { //Si le code d'un des éléments existant correspond, alors on l'ajoute
		    		elementQuantiteSortie.put(e, quantiteElementSortie);
		    	}
		    }
		    
		    //On ajoute le tout dans la ArrayList statique des chaînes
		    Chaine.LesChaines.add(new Chaine(nextLine[0], nextLine[1], Double.parseDouble(nextLine[4]),
		    	elementQuantiteEntree, elementQuantiteSortie));

		} //Sortie de la boucle .nextLine()
		
		System.out.println("--- AFFICHAGE DE TOUTES LES CHAINES DEPUIS CHAINE.LESCHAINES ---");
		for (Chaine c : Chaine.LesChaines) {
	    	//System.out.println(c.toString());
	    }
		
	}
}
