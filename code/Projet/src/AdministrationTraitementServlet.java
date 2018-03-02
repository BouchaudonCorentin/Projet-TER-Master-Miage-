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
/** This class is one of the control pattern. It allows to the administrator to control the data.
 * He can delete a client, generate Audit, or give turnover of website.
 * 
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
				int i = 1; // Attention partie non conforme � la tables mots clefs
				for (String item : motclef.split(",")) {
				    mc.add(new MotClef(i,item));
				    i++;
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
				request.setAttribute("ajout_video", !dbi.videoExiste(v));
				
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
					System.out.println(nom+","+pseudo); 
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
					  int id= dbi.IdBypseudo(pseudo); 
					  Client c = new Client();
					  c.setId(id);
					  dbi.suppClient(c);
					  request.setAttribute("echec_suppressionclient",false); 
				  }else {
					  request.setAttribute("echec_suppressionclient",true); 
				  }
				


			    
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