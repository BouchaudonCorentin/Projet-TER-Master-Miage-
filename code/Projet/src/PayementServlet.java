
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Payement")
/** This class allows to the client to pay for a subscribe or a location of video.
 *  Then, this data can be display in the page Payement.
 * 
 * @author Mathilde Pechdimaldjian
 *
 */
public class PayementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public  PayementServlet () {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
		
			DataBase dbi = (DataBase) request.getSession().getAttribute("dbi"); 
			if (dbi == null) {
				dbi = new DataBase();
				request.getSession().setAttribute("dbi", dbi);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/payement.jsp");
			
			
			int id= Integer.parseInt(request.getParameter("id"));
			System.out.println(id); 
			String type = request.getParameter("type");
			Video v = dbi.searchVideoByID(id);
			
			
		
		if(type.equals("Location")) {
			request.setAttribute("prix",(double)Math.round(v.getPrixLocation() * 1000) / 1000 );
			
		}else if(type.equals("Achat")) {
			request.setAttribute("prix", (double)Math.round(v.getPrixAchat() * 1000) / 1000 );
		}
		request.setAttribute("type",type);
		request.setAttribute("idfilm",id);
		request.setAttribute("nom", v.getNomVideo());;
		rd.forward(request, response);
			
			
		} catch (Exception e) {
			throw new ServletException (e);
		
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}