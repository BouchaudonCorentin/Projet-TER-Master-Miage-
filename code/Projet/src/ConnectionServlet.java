


import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Connection")
public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ConnectionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pseudo = request.getParameter("pseudo");
		String mdp = request.getParameter("mdp");
		
		try {
		
			DataBase dbi = (DataBase) request.getSession().getAttribute("dbi");
			if (dbi == null) {
				dbi = new DataBase();
				request.getSession().setAttribute("dbi", dbi);
			}
			
			List<Video> lv = dbi.afficheVideosansDoublon();
			request.setAttribute("carroussel", lv.subList(0, 3));
			// request.setAttribute("carroussel", lv.subList(lv.size()-3, lv.size())); quand il y aura des affiches pour les derniers fils -- bonne version
			request.setAttribute("carsl_supp", Arrays.asList("first", "second", "third"));
			request.setAttribute("videos", lv);

			Client client = dbi.connection(new Client(pseudo, mdp));
			request.getSession().setAttribute("status", dbi.categorieclient(client));
			request.getSession().setAttribute("client", client); // Si le client donné n'existe pas, le client retourné est à null
			if(client == null) request.setAttribute("echec_connection", true);
			
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp"); //Charge un JSP
			rd.forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException (e);
		
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
