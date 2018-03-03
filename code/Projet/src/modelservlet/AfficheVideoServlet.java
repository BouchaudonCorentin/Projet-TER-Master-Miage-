package modelservlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AfficheVideo")
/** This class allows to display a video in the page AfficheVideo
 * 
 * 
 * @author Mathilde Pechdimaldjian
 *
 */
public class AfficheVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public  AfficheVideoServlet() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
		
			DataBase dbi = (DataBase) request.getSession().getAttribute("dbi");
			
			if (dbi == null) {
				dbi = new DataBase();
				request.getSession().setAttribute("dbi", dbi);
			}
			Client c = (Client) request.getSession().getAttribute("client"); 
			RequestDispatcher rd = request.getRequestDispatcher("/afficheVideo.jsp");
			int id= Integer.parseInt(request.getParameter("idvideo")); 
			request.setAttribute("id",id);
			Video v = dbi.searchVideoByID(id);
			request.setAttribute("nom", v.getNomVideo());
			request.setAttribute("ep", v.getNumepisode());
			request.setAttribute("resume", v.getResume());
			request.setAttribute("saison", v.getGroupeVideo());
			request.setAttribute("vues", v.getNbvue());
			dbi.incrementevue(v); 
			List<MotClef> mc = dbi.motClefvideo(v); 
			request.setAttribute("suggestion", dbi.suggestions(v, mc));
			rd.forward(request, response);
			
			
		} catch (Exception e) {
			throw new ServletException (e);
		
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}