import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AdministrationTraitement")
public class AdministrationTraitementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public  AdministrationTraitementServlet() {
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
			String action= request.getParameter("action"); 
			
			  if(action.equals("Add_Video")){
				String nom = request.getParameter("a_nom");
				int ep = Integer.parseInt(request.getParameter("a_ep"));
				String motclef = request.getParameter("a_motclef"); //liste a gerer 
				String resume = request.getParameter("a_resume");
				String cat = request.getParameter("a_cat");
				double louer = Double.parseDouble(request.getParameter("a_louer"));
				double achat = Double.parseDouble(request.getParameter("a_achat"));
			/*	Video v = new Video(nom,cat,ep,resume,0,achat,louer); 
				
				  request.setAttribute("Add_Video", dbi.ajoutVideo(v, cate, mc));
				 
			    */
			  }else if (action.equals("del_Video")){
			    
			  }else if (action.equals("Add_Client")) {
			    
			  }else if (action.equals("Del_Client")) {
			    
			  }else if (action.equals("Audit")) {
			      
			  }else if (action.equals("CA")) {
			    
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