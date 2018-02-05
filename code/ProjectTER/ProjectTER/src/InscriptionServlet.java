import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InscriptionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String pseudo = request.getParameter("pseudo");
		String mdp = request.getParameter("mdp");
		String email = request.getParameter("email");
		
		try {
		
		DataBase dbi = (DataBase) request.getSession().getAttribute("dbi");
				if (dbi == null) {
				          dbi = new DataBase();
				request.getSession().setAttribute("dbi", dbi);
				}
			if (dbi.verifpseudo(pseudo) == false){
				RequestDispatcher rd = request.getRequestDispatcher("/Inscription.jsp");
				rd.forward(request, response);
			}
			Client client = new Client(nom,prenom,pseudo,mdp,email);
			request.setAttribute("client", dbi.inscription(client));
			RequestDispatcher rd = request.getRequestDispatcher("/Inscription.jsp");
			rd.forward(request, response);
			
			
		} catch (Exception e) {
			throw new ServletException (e);
		
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

