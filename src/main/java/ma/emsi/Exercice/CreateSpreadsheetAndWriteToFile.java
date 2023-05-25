package ma.emsi.Exercice;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CreateSpreadsheetAndWriteToFile {

	   public static void main(String[] args) throws Exception {

		      //Création d'un objet de type fichier Excel
		      XSSFWorkbook workbook = new XSSFWorkbook();

		      //Création d'un objet de type feuille Excel
		      XSSFSheet spreadsheet = workbook.createSheet(" Voiture Info ");

		      //Création d'un objet row (ligne)
		      XSSFRow row;

		      //Les données à inserer;
		      Map < String, Object[] > vtrinfo =
		      new TreeMap < String, Object[] >();
			  vtrinfo.put( "1", new Object[] { "6A19992", "BMW", "noir",180000,17000,220 });
			  vtrinfo.put( "2", new Object[] { "6A19992", "BMW", "noir",180000,17000,220  });
			  vtrinfo.put( "3", new Object[] { "6A19992", "BMW", "noir",180000,17000,220  });
			  vtrinfo.put( "4", new Object[] { "6A19992", "BMW", "noir",180000,17000,220 });
			  vtrinfo.put( "5", new Object[] { "6A19992", "BMW", "noir",180000,17000,220  });
			  vtrinfo.put( "6", new Object[] { "6A19992", "BMW", "noir",180000,17000,220  });

		      //parcourir les données pour les écrire dans le fichier Excel
		      Set < String > keyid = vtrinfo.keySet();
		      int rowid = 0;

		      for (String key : keyid) {
		         row = spreadsheet.createRow(rowid++);
		         Object [] objectArr = vtrinfo.get(key);
		         int cellid = 0;

		         for (Object obj : objectArr) {
		            Cell cell = row.createCell(cellid++);
		            cell.setCellValue(String.valueOf(obj));
		         }
		      }

		      //Excrire les données dans un FileOutputStream
		      FileOutputStream out = new FileOutputStream(new File("src/main/resources/VoitureSpreadSheet.xlsx"));
		      workbook.write(out);
		      out.close();
		      System.out.println("Travail bien fait!!!");
		   }

}
