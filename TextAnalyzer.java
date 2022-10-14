import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


public class TextAnalyzer {
	static void countFrequencies(String fileName, Map<String, Integer> stats) throws FileNotFoundException {
	
		Scanner file = new Scanner(new File(fileName));
		file.toString().equalsIgnoreCase(fileName);
		file.toString().replace("/", "");
		file.toString().replace("-", "");	
		file.toString().replace(";", "");
		file.toString().replace("”", "");
		file.toString().replace(".", "");
		file.toString().replace(",", "");
		file.toString().replace("!", "");
		file.toString().replace("“", "");
		
		
			
		while (file.hasNext() ) {
			String word = file.next();
			Integer count = stats.get(word);
			if (count != null)
				count++;
			else
				count = 1;
			stats.put(word, count);
		}
		file.close();
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		Map<String, Integer> stats = new HashMap<String, Integer>();
		countFrequencies("C:\\Users\\fatim\\eclipse-workspace\\SDLC Assignment\\TheRavenPoem.txt", stats);
		System.out.println("The Reven Poem Words and their frequencies sorted ");
		stats.entrySet().stream().sorted(
			Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
		.limit(20)	 
		 .collect(Collectors.toMap(
                 Map.Entry::getKey,
                 Map.Entry::getValue,
                 (e1, e2) -> e1,
                 LinkedHashMap::new
         )).forEach((s, integer) -> System.out.println(String.format("%s : %s", s, integer)));
		

	}

	

}
