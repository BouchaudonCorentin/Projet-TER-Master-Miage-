package modelservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AdministrationTraitement")
/** 
 * Permet de traiter les actions qu'un admnistrateur souhaite effectuer cmme suppression client ou modfication film 
 * @author Mathilde Pechdimaldjian
 *
 */
public class AdministrationTraitementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public  AdministrationTraitementServlet() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
		
			DataBase dbi = (DataBase) request.getSession().getAttribute("dbi");
			
			if (dbi == null) {
				dbi = new DataBase();
				request.getSession().setAttribute("dbi", dbi);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/administration.jsp");
			String action= request.getParameter("action"); 

			  if(action.equals("Add_Video")){
				String nom = request.getParameter("a_nom");
				String motclef = request.getParameter("a_motclef"); //liste a gerer 
				String resume = request.getParameter("a_resume");
				ArrayList<MotClef> mc = new ArrayList<MotClef>();
				for (String item : motclef.split(",")) {
				    mc.add(new MotClef(Integer.parseInt(item)));
				}
				//genere la liste de mots clefs 
				int ep = Integer.parseInt(request.getParameter("a_ep"));
				String saison = request.getParameter("a_saison");
				int cat = Integer.parseInt(request.getParameter("a_categorie"));
				
				double louer = Double.parseDouble(request.getParameter("a_louer"));
				
				double achat = Double.parseDouble(request.getParameter("a_achat"));
				Video v = new Video(nom,saison,ep,resume,0,0,achat,louer);
				v.setId((dbi.recupDernierID().getId()+1));
				CategorieVideo c = new CategorieVideo(cat); 
				dbi.ajoutVideo(v, c, mc);
				request.setAttribute("ajout_video", dbi.videoExiste(v));
				
			  }else if (action.equals("Del_Video")){
				  String titre = request.getParameter("d_titre_V");
				  int ep = Integer.parseInt(request.getParameter("d_episode_V")); 
				  String saison = request.getParameter("d_saison");
				  Video v = new Video (titre,saison,ep);
					 if(!dbi.videoExiste(v)) {
						  Video vid = dbi.retrouveridvianomnomgroupetnbepisode(v); 
						  dbi.suppVideo(vid);
						  request.setAttribute("echec_suppressionVideo", false);
						
					 }else {
						 request.setAttribute("echec_suppressionVideo", true);
					 }
				   
			  }else if (action.equals("Add_Client")) {
					String nom = request.getParameter("a_nom");
					String prenom = request.getParameter("a_prenom");
					String pseudo = request.getParameter("a_pseudo");
					String mdp = request.getParameter("a_mdp");
					String email = request.getParameter("a_email");
					
					Client client;
					
					if (dbi.verifpseudo(pseudo) == false){
					request.setAttribute("echec_inscription", true); 
					}else {
						client = dbi.inscription(new Client(nom,prenom,pseudo,mdp,email));
						request.setAttribute("echec_inscription", false); 
					}
					
			    
			  }else if (action.equals("Del_Client")) {
				  String pseudo = request.getParameter("d_pseudo");
				  if(!dbi.verifpseudo(pseudo)) {
					  int id= dbi.idByPseudo(pseudo); 
					  Client c = new Client();
					  c.setId(id);
					  dbi.suppClient(c);
					  request.setAttribute("echec_suppressionclient",false); 
				  }else {
					  request.setAttribute("echec_suppressionclient",true); 
				  }
				


			  }else if (action.equals("Mod_Client")) {
				  //pour trouver
				  String m_pseudo = request.getParameter("m_pseudo");
				  //a changer
				  String m_nom = request.getParameter("m_nom");
				  String m_prenom = request.getParameter("m_prenom");
				  String m_mdp = request.getParameter("m_mdp");
				  String m_email = request.getParameter("m_email");
				  int id= dbi.idByPseudo(m_pseudo);
				  Client c = new Client(id,m_nom,m_prenom,m_pseudo,m_mdp,m_email);
				  boolean res = dbi.modifClient(c);
				  request.setAttribute("echec_modidierclient",!res); 
				  System.out.println(c.getPseudo()+" "+c.getNom());
				  
			  }else if (action.equals("Mod_Film")) { 
				  //pour trouver
				  String m_titre = request.getParameter("m_titre");
				  int m_ep =Integer.parseInt( request.getParameter("m_ep"));
				  String m_saison = request.getParameter("m_saison");
			      //a changer
				  String m_resume = request.getParameter("m_resume");
				  String m_location = request.getParameter("m_location");
				  String m_achat = request.getParameter("m_location");
				  Video v = new Video(m_titre,m_saison,m_ep);
				  v.setResume(m_resume);
				  v.setPrixAchat(Double.parseDouble(m_achat));
				  v.setPrixLocation(Double.parseDouble(m_location));
				  boolean resv = dbi.modifVideo(v); 
				  request.setAttribute("echec_modidierVideo",!resv); 
				  System.out.println(v.getPrixAchat());
			  }else if (action.equals("Audit")) {
			      
			  }else if (action.equals("CA")) {
			    
			  }
				request.setAttribute("nbvideo", dbi.afficheVideos().size());
				request.setAttribute("nbMembre", dbi.listpseudoclients().size());
				request.setAttribute("nbPremium", dbi.listMembrepremium());
			rd.forward(request, response);
			
			
		} catch (Exception e) {
			throw new ServletException (e);
		
		}
	
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}