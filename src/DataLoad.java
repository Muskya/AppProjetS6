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
	
	//Le main est dans cette classe, car la première chose que fait le programme
	//est le chargement des données. (sujet à changer lors de l'implémentation de l'interface
	//graphique
	public static void main(String[] args) throws IOException {
		
		
		final String csv_file = "C:\\Users\\ThéoRebbouh\\Documents\\WorkspaceEclipse\\AppProjetS6\\src\\chaines.csv";
		Path filePath = Paths.get(csv_file);
		
		CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
        
        try (BufferedReader br = Files.newBufferedReader(filePath, Charset.forName("ISO-8859-1"));
                CSVReader reader = new CSVReaderBuilder(br).withCSVParser(parser)
                        .build()) {

            List<String[]> rows = reader.readAll();

            System.out.println("Juste avant le for");
            for (String[] row : rows) {

                for (String e : row) {
                    System.out.format("%s ", e);
                }

                System.out.println();
            }
            
        }
		
		
	}
	
	
}
