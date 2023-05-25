package ma.emsi.Exercice;


import ma.emsi.classe.Voiture;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadWriteTxtFileAndBindWithObject {
	  public static void main(String[] args)throws Exception {
	        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/VoitureInputData.txt"));

	        ArrayList<Voiture> list = new ArrayList<Voiture>();
		  	Voiture v = null;
	        String readLine = br.readLine();

	        while(readLine != null){
	        	
	        	String [] voiture  = readLine.split("\\|");
	             
	            
	            v = new Voiture();
                v.setmMtricule(voiture[0].trim());
                v.setMarque(voiture[1].trim());
                v.setCouleur(voiture[2].trim());
                v.setPrix(Double.parseDouble(voiture[3].trim()));
				v.setKilometrage(Double.parseDouble(voiture[3].trim()));
				v.setVitesse(Double.parseDouble(voiture[3].trim()));
                list.add(v);
                readLine = br.readLine();
	        }


	       try( FileOutputStream fout = new FileOutputStream("src/main/resources/voitureOutputData.txt"))
	       {

	        for(Voiture vtr : list){
	            fout.write(vtr.toString().getBytes());
	            fout.write('\n');
	            
	            System.out.println("Voiture :"+vtr.toString());
	        }
	       }
	       catch (IOException e) {
	    	   System.out.println(e.getStackTrace());
		}

	    }

	}

