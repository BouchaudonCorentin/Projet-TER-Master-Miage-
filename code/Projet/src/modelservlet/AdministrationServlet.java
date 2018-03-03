package modelservlet;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Administration")
/** This class allows to the administrator to access data that the client can't have
 * (number Client/Premium/Video) 
 * Then, this data can be display in the page Administration.
 * 
 * @author Mathilde Pechdimaldjian
 *
 */
public class AdministrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public  AdministrationServlet() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
		
			DataBase dbi = (DataBase) request.getSession().getAttribute("dbi");
			
			if (dbi == null) {
				dbi = new DataBase();
				request.getSession().setAttribute("dbi", dbi);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/administration.jsp");
			request.setAttribute("nbvideo", dbi.afficheVideos().size());
			request.setAttribute("nbMembre", dbi.listpseudoclients().size());
			request.setAttribute("nbPremium", dbi.listMembrepremium());
			
			rd.forward(request, response);
			
			
		} catch (Exception e) {
			throw new ServletException (e);
		
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}