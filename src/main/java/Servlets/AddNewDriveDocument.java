package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.Drive.Files;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.api.services.drive.model.ParentReference;

/**
 * Servlet implementation class AddNewDriveDocument
 */
public class AddNewDriveDocument extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewDriveDocument() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		
		String accessToken = (String) session.getAttribute("accessToken");
		
		String newDocumentName = request.getParameter("newDocument");
		
		GoogleCredential credential = new GoogleCredential().setAccessToken(accessToken);
		Drive drive =
		    new Drive.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance(), credential)
		        .setApplicationName("GutbrodGomez")
		        .build();
		
		
		File fileMetadata = new File();
		fileMetadata.setTitle(newDocumentName);
		fileMetadata.setMimeType("application/vnd.google-apps.document");
		
		List<ParentReference> parents = new ArrayList<ParentReference>();
        ParentReference fileParent = new ParentReference();
        fileParent.setId("root");
        parents.add(fileParent);
        fileMetadata.setParents(parents);
        
		File file =  drive.files().insert(fileMetadata).execute();
		
		session.setAttribute("newFilename", file);
		
		List<String> fleNames = new ArrayList<String>();
		   List<File> result = new ArrayList<File>();
		    Files.List requestListFiles = drive
                 .files()
                 .list()
                 .setQ("'root' in parents  and trashed=false");
		    try {
		        FileList files = requestListFiles.execute();
		        result.addAll(files.getItems());
		        System.out.println(result);
		        requestListFiles.setPageToken(files.getNextPageToken());
		      } catch (IOException e) {
		        System.out.println("An error occurred: " + e);
		        requestListFiles.setPageToken(null);
		      }
		session.setAttribute("fileList", result);
		response.sendRedirect("DriveFiles.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
