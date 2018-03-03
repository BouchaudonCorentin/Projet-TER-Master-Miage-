
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Recherche")
/** This class allows to display a video in the page AfficheVideo
 * 
 * 
 * @author Mathilde Pechdimaldjian
 *
 */
public class RechercheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public  RechercheServlet() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
		
			DataBase dbi = (DataBase) request.getSession().getAttribute("dbi");
			
			if (dbi == null) {
				dbi = new DataBase();
				request.getSession().setAttribute("dbi", dbi);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/recherche.jsp");
			String cat = request.getParameter("cat");
			List<Video> lv; 
			if(cat.equals("motsclefs")) {
				ArrayList<MotClef> mc = new ArrayList<MotClef>() ;
				String[] checks =request.getParameterValues("check");
				for (int i = 0; i < checks.length; i++) {
				      mc.add(new MotClef(Integer.parseInt(checks[i])));
				    }

				lv = dbi.rechercheVideoMC(mc);
			
			}else {
				CategorieVideo cv = new CategorieVideo (Integer.parseInt(cat)); 
				lv = dbi.rechercheVideoCate(cv);
				
			}
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