package ma.emsi.Exercice;

import com.google.gson.Gson;
import ma.emsi.classe.Voiture;

import java.util.ArrayList;
import java.util.List;


public class JsonDataBindWithJavaObject {

public static void main(String[] args) {
		
		List<Voiture> VoitureList = new ArrayList<Voiture>();
		Voiture voitureObj= null;
		
		String VoitureJson = "[{'matricule': '6A32323','marque': 'BMW','couleur': 'noir','prix': 180000,'kilometrage': 10000,vitesse: 220},{'matricule': '6A32323','marque': 'merced','couleur': 'noir','prix': 180000,'kilometrage': 10000,vitesse: 220}]";

		Gson gson = new Gson();  
		Voiture[] VoitureArray = gson.fromJson(VoitureJson, Voiture[].class);
		
		for(Voiture obj:VoitureArray) {
			voitureObj = new Voiture();
			voitureObj.setmMtricule(obj.getMarque());
			voitureObj.setMarque(obj.getMarque());
			voitureObj.setCouleur(obj.getCouleur());
			voitureObj.setPrix(obj.getPrix());
			voitureObj.setKilometrage(obj.getKilometrage());
			voitureObj.setVitesse(obj.getVitesse());
			VoitureList.add(voitureObj);
		}
		
		for(Voiture obj2:VoitureList) {
			System.out.println(obj2.getMarque());
		}

	}

}
