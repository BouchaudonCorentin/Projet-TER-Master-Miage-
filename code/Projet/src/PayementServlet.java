
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Payement")
/** This class is one of the control pattern. She send data and control the data send to the vue
 * We use this class for the payement of the premium of the location of the film
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
		
			DataBase dbi = (DataBase) request.getSession().getAttribute("dbi"); // Stock du modele de DB
			
			if (dbi == null) {
				dbi = new DataBase();
				request.getSession().setAttribute("dbi", dbi);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/payement.jsp");
			
			int id= Integer.parseInt(request.getParameter("id")); //Stock les parametres dans request 
			String type = request.getParameter("type"); 
			System.out.println(type);
			rd.forward(request, response);
			
			
		} catch (Exception e) {
			throw new ServletException (e);
		
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}