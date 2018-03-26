package modelservlet;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CompteClient")
/** 
 * 
 * @author MMathilde Pechdimaldjian
 *
 */
public class CompteClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public  CompteClientServlet () {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
		
			DataBase dbi = (DataBase) request.getSession().getAttribute("dbi"); 
			
			if (dbi == null) {
				dbi = new DataBase();
				request.getSession().setAttribute("dbi", dbi);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/compteClient.jsp"); 
			Client c = (Client) request.getSession().getAttribute("client"); 
			List<Video> a = dbi.achatsUser(c); 
			List<Video> lc = dbi.locationsCouranteUser(c); 
			List<Video> lf = dbi.vieilleLocationsUser(c);
			request.setAttribute("a", a);
			request.setAttribute("lc", lc);
			request.setAttribute("lf", lf);
		
			if(dbi.isParrain(c.getId())==true)
			{
				 
				Parrain p =dbi.getInfoParrain(c.getId());
				request.setAttribute("neveuNom",dbi.pseudoById(p.getIdNeveu()));
				request.setAttribute("parrain",p);	
			}
			if(dbi.categorieclient(c).getCategorie().equals("premium") )
			{
				
				SimpleDateFormat formDate = new SimpleDateFormat("dd/MM/yyyy");
				
				String dateString = formDate.format(dbi.dateFinPremium(c.getId()) );
				request.setAttribute("dateFin",dateString);
			
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