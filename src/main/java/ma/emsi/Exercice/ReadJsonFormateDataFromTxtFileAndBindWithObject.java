package ma.emsi.Exercice;

import com.google.gson.Gson;
import ma.emsi.classe.Voiture;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadJsonFormateDataFromTxtFileAndBindWithObject {
	
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
	

	   JSONParser parser = new JSONParser();
       Object obj = parser.parse(new FileReader("src/main/resources/jsonVoiture.txt"));
       JSONObject jsonObject = (JSONObject) obj;
       
       String jsonObjectList = jsonObject.get("voitureList").toString();
       
	   	Gson gson = new Gson();  
	   	Voiture[] vtrArray = gson.fromJson(jsonObjectList, Voiture[].class);
		
		for(Voiture obj2 : vtrArray) {
			
			System.out.println(obj2.getMarque());
			
		}
		

  }

}
