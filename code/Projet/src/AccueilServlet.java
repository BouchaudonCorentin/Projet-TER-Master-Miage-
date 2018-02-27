
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AccueilServlet() {
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
		
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			
			request.setAttribute("carroussel", dbi.recupDernierID());
	
			request.setAttribute("videos", dbi.afficheVideosansDoublon());

			
			rd.forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException (e);
		
		}
	
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

