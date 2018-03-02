
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DetailVideo")
/** This class allows to the vue to display the data of each video, like the name, price, resume�
 * As a connected user it allows to buy or rent the video 
 * and as a premium member there is an access to directly watch the video.
 * 
 * @author Mathilde Pechdimaldjian
 *
 */
public class DetailVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public  DetailVideoServlet() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
		
			DataBase dbi = (DataBase) request.getSession().getAttribute("dbi");
			
			if (dbi == null) {
				dbi = new DataBase();
				request.getSession().setAttribute("dbi", dbi);
			}
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/infoVideo.jsp");
			//recherche film 
			
			int id= Integer.parseInt(request.getParameter("idVideo")); 
			request.setAttribute("id",id);
			Video v = dbi.searchVideoByID(id);
			request.setAttribute("nom", v.getNomVideo());
			request.setAttribute("ep", v.getNumepisode());
			request.setAttribute("p_achat", (double)Math.round(v.getPrixAchat() * 1000) / 1000 );
			request.setAttribute("p_louer",(double)Math.round(v.getPrixLocation() * 1000) / 1000 );
			request.setAttribute("resume", v.getResume());
			request.setAttribute("saison", v.getGroupeVideo());
			//verifier client connect�
			Client c = (Client) request.getSession().getAttribute("client");
			if(c!=null) {
				request.setAttribute("louer", dbi.isRent(c, v));
				request.setAttribute("achat", dbi.isBuy(c, v));
				System.out.println(dbi.isBuy(c, v));
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