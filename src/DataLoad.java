import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

abstract public class DataLoad {
	
	
	public static void main(String[] args) {
		 List<Element> elems = Load("elements.csv");

	        // let's print all the person read from CSV file
	        for (Element e : elems) {
	            System.out.println(e.toString());
	        }
	}
	
	public static List<Element> Load(String fileName) {
		List<Element> elems = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                Charset.forName("UTF-8"))) {

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");

                Element el = createElement(attributes);

                // adding book into ArrayList
                elems.add(el);
                
                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        } catch (IOException ioe) {
            System.out.println("Problème lors de la création d'un buffer reader");
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
        
        return elems;
    }
	
	private static Element createElement(String[] metadata) {
        String code = metadata[0];
        String nom = metadata[1];
        int quantite = Integer.parseInt(metadata[2]);
        String unite = metadata[3];
        
        // create and return book of this metadata
        return new Element(code, nom, quantite, unite);
    }
}
