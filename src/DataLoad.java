import com.opencsv.*;
import java.io.*; //ioexception, reader
import java.nio.*; //files, paths
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

abstract public class DataLoad {
	
	static String csv_file; //Contient le chemin vers le .csv à charger
	static Path filePath; //Contient la référence de localisation du .csv
	static CSVParser parser; //Définit le "pattern" de récupération des données des .csv
	static BufferedReader br; //Permet la lecture des données d'un .csv
	static CSVReader reader;
	
	//Le main est dans cette classe, car la première chose que fait le programme
	//est le chargement des données. (sujet à changer lors de l'implémentation de l'interface
	//graphique
	public static void main(String[] args) throws IOException {
		
		try {
			parser = new CSVParserBuilder().withSeparator(';').build();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		DataElements("C:\\Users\\ThéoRebbouh\\Documents\\WorkspaceEclipse\\AppProjetS6\\src\\elements.csv");
		//DataChaines("C:\\Users\\ThéoRebbouh\\Documents\\WorkspaceEclipse\\AppProjetS6\\src\\chaines.csv");
	}
	
	//Récupération des données d'elements.csv
	public static void DataElements(String pathElementsCSV) throws IOException {
		//Variables nécessaires au chargement de données		
				
		//Initialisation des différents objets permettant la récupération des données du .csv
		csv_file = pathElementsCSV;
		filePath = Paths.get(csv_file); 
		br = Files.newBufferedReader(filePath, Charset.forName("ISO-8859-1"));
		reader = new CSVReaderBuilder(br).withCSVParser(parser).withSkipLines(1).build();
				
		System.out.println("---Chargement des données des éléments (matières premières et produits)---");
		        	
		String [] nextLine;
		while ((nextLine = reader.readNext()) != null) {
			//Affiche chaque ligne du .csv
		        		
		    System.out.println("Création nouvel élément avec pour valeurs :");
		    System.out.println("Code: " + nextLine[0] + ", Nom: " + nextLine[1] 
		        	 + ", Quantité: " + nextLine[2] + ", Unité: " + nextLine[3] + "\n");
		    Element.lesElements.add(new Element
		        	 (nextLine[0], nextLine[1], Integer.parseInt(nextLine[2]), nextLine[3]));
		    //Integer.parseInt car les éléments de nextLine sont tous des String, et on a besoin
		    //d'un Int dans le constructeur pour la quantité.
		}
		        	
		System.out.println("Tous les éléments ont été chargés.");
		System.out.println("Les voici :");
		for (Element e : Element.lesElements) {
			System.out.println(e.toString());
		}
		            
	}
	
	//Récupération des données de chaines.csv
	public static void DataChaines(String pathChainesCSV) throws IOException {
		//Initialisation des différents objets permettant la récupération des données du .csv
		csv_file = pathChainesCSV;
		filePath = Paths.get(csv_file); 
		br = Files.newBufferedReader(filePath, Charset.forName("ISO-8859-1"));
		reader = new CSVReaderBuilder(br).withCSVParser(parser).withSkipLines(1)
                .build();
		
		//Récupération et traitement des données
	}
	
	
	
	
}
