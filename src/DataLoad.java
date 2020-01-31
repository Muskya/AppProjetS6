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
	
	static String csv_file; //Contient le chemin vers le .csv � charger
	static Path filePath; //Contient la r�f�rence de localisation du .csv
	static CSVParser parser; //D�finit le "pattern" de r�cup�ration des donn�es des .csv
	static BufferedReader br; //Permet la lecture des donn�es d'un .csv
	static CSVReader reader;
	
	//Le main est dans cette classe, car la premi�re chose que fait le programme
	//est le chargement des donn�es. (sujet � changer lors de l'impl�mentation de l'interface
	//graphique
	public static void main(String[] args) throws IOException {
		
		try {
			parser = new CSVParserBuilder().withSeparator(';').build();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		DataElements("C:\\Users\\Th�oRebbouh\\Documents\\WorkspaceEclipse\\AppProjetS6\\src\\elements.csv");
		//DataChaines("C:\\Users\\Th�oRebbouh\\Documents\\WorkspaceEclipse\\AppProjetS6\\src\\chaines.csv");
	}
	
	//R�cup�ration des donn�es d'elements.csv
	public static void DataElements(String pathElementsCSV) throws IOException {
		//Variables n�cessaires au chargement de donn�es		
				
		//Initialisation des diff�rents objets permettant la r�cup�ration des donn�es du .csv
		csv_file = pathElementsCSV;
		filePath = Paths.get(csv_file); 
		br = Files.newBufferedReader(filePath, Charset.forName("ISO-8859-1"));
		reader = new CSVReaderBuilder(br).withCSVParser(parser).withSkipLines(1).build();
				
		System.out.println("---Chargement des donn�es des �l�ments (mati�res premi�res et produits)---");
		        	
		String [] nextLine;
		while ((nextLine = reader.readNext()) != null) {
			//Affiche chaque ligne du .csv
		        		
		    System.out.println("Cr�ation nouvel �l�ment avec pour valeurs :");
		    System.out.println("Code: " + nextLine[0] + ", Nom: " + nextLine[1] 
		        	 + ", Quantit�: " + nextLine[2] + ", Unit�: " + nextLine[3] + "\n");
		    Element.lesElements.add(new Element
		        	 (nextLine[0], nextLine[1], Integer.parseInt(nextLine[2]), nextLine[3]));
		    //Integer.parseInt car les �l�ments de nextLine sont tous des String, et on a besoin
		    //d'un Int dans le constructeur pour la quantit�.
		}
		        	
		System.out.println("Tous les �l�ments ont �t� charg�s.");
		System.out.println("Les voici :");
		for (Element e : Element.lesElements) {
			System.out.println(e.toString());
		}
		            
	}
	
	//R�cup�ration des donn�es de chaines.csv
	public static void DataChaines(String pathChainesCSV) throws IOException {
		//Initialisation des diff�rents objets permettant la r�cup�ration des donn�es du .csv
		csv_file = pathChainesCSV;
		filePath = Paths.get(csv_file); 
		br = Files.newBufferedReader(filePath, Charset.forName("ISO-8859-1"));
		reader = new CSVReaderBuilder(br).withCSVParser(parser).withSkipLines(1)
                .build();
		
		//R�cup�ration et traitement des donn�es
	}
	
	
	
	
}
