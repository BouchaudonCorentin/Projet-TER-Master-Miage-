
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AccueilServlet")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AccueilServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String recherche = request.getParameter("recherche");
		String pseudo = request.getParameter("pseudo"); // On récupère les parametres utile pour créer un client
		String mdp = request.getParameter("mdp");
		Client client = null;
		
		
		try {
			
			DataBase dbi = (DataBase) request.getSession().getAttribute("dbi"); // Stock du modèle de DB
			if (dbi == null) 
			{
	          dbi = new DataBase();
	          request.getSession().setAttribute("dbi", dbi);
			}
			
			request.setAttribute("carroussel", dbi.RecupDernierID())
			request.setAttribute("recherche", dbi.RechercheVideo(recherche))
			request.setAttribute("Video", dbi.afficheVideo());	// request permet de stocker les attributs de requete
			
			if (client == null) {
				RequestDispatcher rd = request.getRequestDispatcher("/Connection.jsp"); //Charge un JSP
			}
			
			else {
				RequestDispatcher rd = request.getRequestDispatcher("/detailsfilm.jsp"); //Charge un JSP
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

