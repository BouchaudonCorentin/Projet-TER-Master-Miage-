
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
			
			List<Video> lv = dbi.afficheVideosansDoublon();
			request.setAttribute("carroussel", lv.subList(0, 3));
			// request.setAttribute("carroussel", lv.subList(lv.size()-3, lv.size())); quand il y aura des affiches pour les derniers fils -- bonne version
			request.setAttribute("carsl_supp", Arrays.asList("first", "second", "third"));
			request.setAttribute("videos", lv);

			
			rd.forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException (e);
		
		}
	
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

