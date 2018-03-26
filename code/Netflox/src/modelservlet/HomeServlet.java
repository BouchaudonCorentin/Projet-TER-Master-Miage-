package modelservlet;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Home", "/Connection", "/Inscription", "/Deconnection"})
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public HomeServlet() {
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

			String uri = request.getRequestURI();


			List<Video> lv = dbi.afficheVideosansDoublon();
			request.setAttribute("carroussel", lv.subList(0, 3));
			// request.setAttribute("carroussel", lv.subList(lv.size()-3, lv.size())); quand il y aura des affiches pour les derniers fils -- bonne version
			request.setAttribute("carsl_supp", Arrays.asList("first", "second", "third"));
			request.setAttribute("videos", lv);

			
			
			
			
			if(uri.equals("/Netflox/Connection")){

				String pseudo = request.getParameter("pseudo");
			
				String mdp = request.getParameter("mdp");
				
				
				
				Client client = dbi.connection(new Client(pseudo, mdp));
				if(client.getId()==0){
					request.setAttribute("echec_connection", true);
				}else {
					
					request.getSession().setAttribute("status", dbi.categorieclient(client)); 
					request.getSession().setAttribute("client", client);
						if(dbi.isParrain(client.getId())==true)
						{
							Parrain p =dbi.getInfoParrain(client.getId()); 
							request.getSession().setAttribute("parrain",p);
							
						}
						
			
					request.setAttribute("echec_connection", false);
					
				}
			
				
				
			}else if(uri.equals("/Netflox/Inscription"))
			{
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String pseudo = request.getParameter("pseudo");
				String mdp = request.getParameter("mdp");
				String verifmdp = request.getParameter("verimdp");
				String email = request.getParameter("email");
				String parrain = request.getParameter("parrain");

				Client client = null;
				if(!mdp.equals(verifmdp)) {
					request.setAttribute("echec_password", true);
				}else {
					request.setAttribute("echec_password", false);
					if (dbi.verifpseudo(pseudo) == false){
						request.setAttribute("echec_inscription", true); 
					}else {
						client = dbi.inscription(new Client(nom,prenom,pseudo,mdp,email));
						request.setAttribute("echec_inscription", false);
					//Verification Parrain 
						System.out.println(dbi.isParrain(dbi.idByPseudo(parrain)));
								if(dbi.verifpseudo(parrain)==false && dbi.isParrain(dbi.idByPseudo(parrain))==false) {
									request.setAttribute("echec_parrain", false);
									int idParrain = dbi.idByPseudo(parrain);
									dbi.becomeNeveu(idParrain, client.getId());
								}else {
									request.setAttribute("echec_parrain", true);
								}
								
			
					}
					request.setAttribute("client", client);
				}
				
				
			}else if(uri.equals("/Netflox/Deconnection")){
				
				 request.getSession().invalidate();
				
			}


			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			throw new ServletException (e);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
