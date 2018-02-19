package projet.tp08;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ConnectionServlet")
public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ConnectionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pseudo = request.getParameter("pseudo"); // On récupère les parametres utile pour créer un client
		String mdp = request.getParameter("mdp");
		
		try {
		
		DataBase dbi = (DataBase) request.getSession().getAttribute("dbi");  // Stock du modèle de DB
				if (dbi == null) {
				          dbi = new DataBase();
				request.getSession().setAttribute("dbi", dbi);
				}
			Client client = new Client(pseudo, mdp);
			request.setAttribute("client", dbi.connection(client));
			RequestDispatcher rd = request.getRequestDispatcher("/Connection.jsp"); //Charge un JSP
			rd.forward(request, response);
			
			
		} catch (Exception e) {
			throw new ServletException (e);
		
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
