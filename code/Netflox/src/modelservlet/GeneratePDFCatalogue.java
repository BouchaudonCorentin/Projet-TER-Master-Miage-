package modelservlet;

import com.itextpdf.text.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.List;
import com.itextpdf.text.pdf.PdfWriter;
/** 
 * Created by Corentin Bouchaudon
 * */

public class GeneratePDFCatalogue {
	
	public static final String RESULT = "catalogue.pdf";
	
	
	public GeneratePDFCatalogue() {};
	
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws DocumentException
	 * @throws FileNotFoundException
	 */
	public void createCatalogue() throws ClassNotFoundException, SQLException, DocumentException, FileNotFoundException {
		
		DataBase db = new DataBase();
		List<Video> videos = db.afficheVideoscroissant();
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(RESULT));
		document.open();
		document.add( new Paragraph("=============================Catalogue de Netflox============================="));
		document.add( new Paragraph("Nom de la video = nom de la video"));
		document.add( new Paragraph("Saison = Different de null si c'est une serie"));
		document.add( new Paragraph("Numero de l'epside = 0 si n'a pas de suite ou n'est pas un episode d'un serie"));
		
		for (int i =0; i<videos.size();i++) {
			document.add(new Paragraph("=======================Video numero "+(i+1)+"======================="));
			document.add(new Paragraph("Nom de la Video :"+ videos.get(i).getNomVideo()));
		if(videos.get(i).getGroupeVideo()!="") {
			document.add(new Paragraph("Saison :"+ videos.get(i).getGroupeVideo()));			
			document.add(new Paragraph("Numero de l'episode :"+videos.get(i).getNumepisode()));
		}
			
		}	
		document.close();
	}
	
	/**
	 * @param argv
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws DocumentException
	 */
	public static void main(String[] argv) throws ClassNotFoundException, FileNotFoundException, SQLException, DocumentException {
		GeneratePDFCatalogue cata = new GeneratePDFCatalogue();
		cata.createCatalogue();
	}

}
