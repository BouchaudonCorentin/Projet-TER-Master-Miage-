import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AdministrationTraitement")
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
				int i = 1; // Attention partie non conforme à la tables mots clefs
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
				Video v = new Video(nom,saison,ep,resume,0,achat,louer);
				v.setId((dbi.recupDernierID().getId()+1));
				CategorieVideo c = new CategorieVideo(cat); 
				request.setAttribute("Add_Video", dbi.ajoutVideo(v, c, mc));
				 
			   
			  }else if (action.equals("Del_Video")){
				  String titre = request.getParameter("d_titre_V");
				  int ep = Integer.parseInt(request.getParameter("d_ep_V")); //liste a gerer 
				  String saison = request.getParameter("d_saison");
				  Video v = new Video (titre,saison,ep);
				  Video i= dbi.retrouveridvianomnomgroupetnbepisode(v); 
				  System.out.println(i.getId());
				  request.setAttribute("Del_Video", dbi. suppVideo(i));
				 
				  
			  }else if (action.equals("Add_Client")) {
			    
			  }else if (action.equals("Del_Client")) {
			    
			  }else if (action.equals("Audit")) {
			      
			  }else if (action.equals("CA")) {
			    
			  }
			
			rd.forward(request, response);
			
			
		} catch (Exception e) {
			throw new ServletException (e);
		
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}