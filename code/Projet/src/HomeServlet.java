
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Home", "/Connection", "/Inscription", "/Deconnection"})
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public HomeServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		try {

			DataBase dbi = (DataBase) request.getSession().getAttribute("dbi"); // Stock du modèle de DB
			if (dbi == null)
			{
	          dbi = new DataBase();
	          request.getSession().setAttribute("dbi", dbi);
			}

			String uri = request.getRequestURI();


			List<Video> lv = dbi.afficheVideosansDoublon();
			request.setAttribute("carroussel", lv.subList(0, 3));
			// request.setAttribute("carroussel", lv.subList(lv.size()-3, lv.size())); quand il y aura des affiches pour les derniers fils -- bonne version
			request.setAttribute("carsl_supp", Arrays.asList("first", "second", "third"));
			request.setAttribute("videos", lv);

			if(uri.equals("/Projet-TER/Connection")){

				String pseudo = request.getParameter("pseudo");
				String mdp = request.getParameter("mdp");

				Client client = dbi.connection(new Client(pseudo, mdp));
				request.getSession().setAttribute("status", dbi.categorieclient(client));
				request.getSession().setAttribute("client", client); // Si le client donn� n'existe pas, le client retourn� est � null
				if(client == null) request.setAttribute("echec_connection", true);
				
			}else if(uri.equals("/Projet-TER/Inscription")){
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String pseudo = request.getParameter("pseudo");
				String mdp = request.getParameter("mdp");
				String email = request.getParameter("email");

				Client client = null;

				if (dbi.verifpseudo(pseudo) == false){
					//request.setAttribute("echec_inscription", true); // � modifier pour nouvelle erreur dans JSP !!
				}else {
					client = dbi.inscription(new Client(nom,prenom,pseudo,mdp,email));
				}
				request.setAttribute("client", client);
			}else if(uri.equals("/Projet-TER/Deconnection")){
				request.getSession().removeAttribute("client");
			}


			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			throw new ServletException (e);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
