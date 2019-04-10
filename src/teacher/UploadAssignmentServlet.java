package teacher;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadAssignmentServlet
 */
@WebServlet("/UploadAssignmentServlet")
@MultipartConfig
public class UploadAssignmentServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Assignment a=new Assignment();
		int assignmentid=a.getAssignmentID();
		HttpSession session=request.getSession();
		int teacherid=Integer.parseInt((String) session.getAttribute("tchrid"));
		int standard=Integer.parseInt((String)session.getAttribute("standard"));
		int subjectid=Integer.parseInt(request.getParameter("subject"));
		Part filePart = request.getPart("assignment");
		String duedate=request.getParameter("duedate");
        InputStream pdfFileBytes = null;
        PrintWriter out = response.getWriter();
        if(session.getAttribute("tchrid")!=null) {
	        try {
	        	if(!filePart.getContentType().equals("application/pdf")){
	        		out.println("<br/> Invalid File");
	        		response.sendRedirect("UploadAssignment1.jsp");
	        	}
	        	else if(filePart.getSize() > 1048576 ){ //2mb
	        		out.println("<br/> File size too big");
	        		response.sendRedirect("UploadAssignment1.jsp");
	        	}
	        	pdfFileBytes = filePart.getInputStream();  // to get the body of the request as binary data
	 
	            final byte[] doc = new byte[pdfFileBytes.available()];
	            pdfFileBytes.read(doc);  //Storing the binary data in bytes array.
	            UploadAssignmentDAO uad=new UploadAssignmentDAO();
	            int ans=uad.uploadDocument(assignmentid, teacherid, subjectid, doc, duedate, standard);
	            if(ans > 0) {
	            	out.println("Assignment uploaded.");
	            }
	            else {
	            	response.sendRedirect("UploadAssignment.jsp");
	            }
	 
	        } 
	        catch (FileNotFoundException fnf) {
	            out.println("You  did not specify a file to upload");
	            out.println("<br/> ERROR: " + fnf.getMessage());
	        } 
	        catch (ClassNotFoundException e) {
	        	out.println(e.getMessage());
				
			} 
	        catch (SQLException e) {
	        	out.println(e.getMessage());
			} 
	        finally {
	        	if (pdfFileBytes != null) {
	                pdfFileBytes.close();
	            }
	            if (out != null) {
	                out.close();
	            }
	        }
        }
        else {
        	response.sendRedirect("TeacherLogin.jsp");
        }   	
	}
}
