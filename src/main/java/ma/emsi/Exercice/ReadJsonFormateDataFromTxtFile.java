package ma.emsi.Exercice;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;

public class ReadJsonFormateDataFromTxtFile {

	public static void main(String[] args) {


		JSONParser parser = new JSONParser();

		try {

			Object obj = parser.parse(new FileReader("src/main/resources/jsonVoitureInput.txt"));

			JSONObject jsonObject = (JSONObject) obj;

			String name = (String) jsonObject.get("Matricule");
			String author = (String) jsonObject.get("Marque");
			JSONArray voitureList = (JSONArray) jsonObject.get("Voiture List");

			System.out.println("Matricule: " + name);
			System.out.println("Marque: " + author);
			System.out.println("\nVoiture List:");
			Iterator<String> iterator = voitureList.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
