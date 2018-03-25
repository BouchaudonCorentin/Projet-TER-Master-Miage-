package modelservlet;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
/**
 * Created by Corentin Bouchaudon
 */
public class GeneratePDFAudit {

	public static final String RESULT = "audit.pdf";

	public GeneratePDFAudit() {
	};

	public void createAudit(Date date) throws ClassNotFoundException, SQLException, DocumentException, FileNotFoundException {

		DataBase db = new DataBase();
		List<Client> clients = db.listpseudoclients();
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(RESULT));
		document.open();
		document.add(new Paragraph("========================Audit de Netflox========================"));
		document.add(new Paragraph("************************Chiffre d'affaire de Netflox************************"));
		document.add(new Paragraph("Le chiffre d'affaire de netflox depuis le "+date.getDate()+"/"+(date.getMonth()+1)+"/"+(date.getYear()+1900)+" est de "+Math.round(db.afficheCA(date))+ " euros"));
		
		document.add(new Paragraph("************************Informations Clients************************"));

		for (int i = 0; i < clients.size(); i++) {
			document.add(new Paragraph("=======================Client numéro " + (i + 1) + "======================="));
			Client c = new Client(clients.get(i).getPseudo());
			c = db.infobypseudo(c.getPseudo());
			document.add(new Paragraph("Nom : " + c.getNom()));
			document.add(new Paragraph("Prenom : " + c.getPrenon()));
			document.add(new Paragraph("Pseudo : " + c.getPseudo()));
			document.add(new Paragraph("Email : " + c.getEmail()));

		}
		document.add(new Paragraph("************************Informations sur Videos************************"));
		List<Video> videos = db.afficheVideoscroissant();
		for (int i = 0; i < videos.size(); i++) {
			document.add(new Paragraph("=======================Video numéro " + (i + 1) + "======================="));
			document.add(new Paragraph("Nom de la Video :" + videos.get(i).getNomVideo()));
			document.add(new Paragraph("Nombre de Vue :" + videos.get(i).getNbvue()));
			document.add(new Paragraph("Nombre de Telechargement :" + videos.get(i).getNbddl()));

		}
		document.close();
	}

	public static void main(String[] argv)
			throws ClassNotFoundException, FileNotFoundException, SQLException, DocumentException {
		GeneratePDFAudit audit = new GeneratePDFAudit();
		Date date = new Date(118,01,01);
		audit.createAudit(date);
	}

}
