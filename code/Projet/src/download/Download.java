package download;
/**
 * @author Brian Lenormand
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DetailVideo")
public class Download extends HttpServlet {
    public static final int TAILLE_TAMPON = 10240; // 10ko
    
    public String path;
    
    public void init() {
    	path = getServletContext().getInitParameter("file");
    }

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = response.getWriter();
        try {
			
        	String fichier = request.getParameter("fichier");
        	path = path + "lol.txt";
        	FileInputStream filedownload = new FileInputStream(path);
        	ServletOutputStream out = response.getOutputStream();
        	response.setContentType("application/octet-stream");
        	response.setHeader("Content-Disposition", "attachment; filename = test");
        	response.setContentLength(filedownload.available());
        	//RequestDispatcher rd = request.getRequestDispatcher("/infoVideo.jsp"); 
    		
			//rd.forward(request, response);
        	
        	int c;
        	while((c=filedownload.read())!=-1) {
        		out.write(c);
        	}
        	out.flush();
        	out.close();
        	filedownload.close();
        	
        	
        }catch(Exception e) {}
        finally {

        }
    }
}



/*package download;
 

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Download extends HttpServlet {
    public static final int TAILLE_TAMPON = 10240; // 10ko

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        
         * Lecture du paramètre 'chemin' passé �  la servlet via la déclaration
         * dans le web.xml
         
        String chemin = this.getServletConfig().getInitParameter( "chemin" );

        
         * Récupération du chemin du fichier demandé au sein de l'URL de la
         * requête
         
        String fichierRequis = request.getPathInfo();
        System.out.println(chemin);
        System.out.println(fichierRequis);
        
         Vérifie qu'un fichier a bien été fourni 
        if ( fichierRequis == null ) {
            
             * Si non, alors on envoie une erreur 404, qui signifie que la
             * ressource demandée n'existe pas
             
            response.sendError( HttpServletResponse.SC_NOT_FOUND );
            return;
        }

        
         * Décode le nom de fichier récupéré, susceptible de contenir des
         * espaces et autres caractères spéciaux, et prépare l'objet File
         
        fichierRequis = URLDecoder.decode( fichierRequis, "UTF-8" );
        File fichier = new File( chemin, fichierRequis );

         Vérifie que le fichier existe bien 
        if ( !fichier.exists() ) {
            
             * Si non, alors on envoie une erreur 404, qui signifie que la
             * ressource demandée n'existe pas
             
            response.sendError( HttpServletResponse.SC_NOT_FOUND );
            return;
        }

         Récupère le type du fichier 
        String type = getServletContext().getMimeType( fichier.getName() );

        
         * Si le type de fichier est inconnu, alors on initialise un type par
         * défaut
         
        if ( type == null ) {
            type = "application/octet-stream";
        }

         Initialise la réponse HTTP 
        response.reset();
        response.setBufferSize( TAILLE_TAMPON );
        response.setContentType( type );
        response.setHeader( "Content-Length", String.valueOf( fichier.length() ) );
        response.setHeader( "Content-Disposition", "attachment; filename=\"" + fichier.getName() + "\"" );

         Prépare les flux 
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try {
             Ouvre les flux 
            entree = new BufferedInputStream( new FileInputStream( fichier ), TAILLE_TAMPON );
            sortie = new BufferedOutputStream( response.getOutputStream(), TAILLE_TAMPON );

             Lit le fichier et écrit son contenu dans la réponse HTTP 
            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur;
            while ( ( longueur = entree.read( tampon ) ) > 0 ) {
                sortie.write( tampon, 0, longueur );
            }
        } finally {
            sortie.close();
            entree.close();
        }
    }
}
*/