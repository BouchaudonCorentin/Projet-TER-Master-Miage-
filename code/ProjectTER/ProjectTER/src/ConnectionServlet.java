

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ConnectionServlet")
public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ConnectionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Client client = (Client) request.getAttribute("client");
		try {
		
		DataBase dbi = (DataBase) request.getSession().getAttribute("dbi");
				if (dbi == null) {
				          dbi = new DataBase();
				request.getSession().setAttribute("dbi", dbi);
				}
			request.setAttribute("client", dbi.connection(client));
			RequestDispatcher rd = request.getRequestDispatcher("/Connection.jsp");
			rd.forward(request, response);
			
			
		} catch (Exception e) {
			throw new ServletException (e);
		
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
