package admin;

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

import teacher.Assignment;

/**
 * Servlet implementation class UploadTimeTableServlet
 */
@WebServlet("/UploadTimeTableServlet")
@MultipartConfig
public class UploadTimeTableServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		int standard=Integer.parseInt((String)session.getAttribute("standard"));
		Part filePart = request.getPart("timetable");
	    InputStream pdfFileBytes = null;
	    PrintWriter out = response.getWriter();
	    if(session.getAttribute("uname")!=null) {
	        try {
	        	if(!filePart.getContentType().equals("application/pdf")){
	        		out.println("<br/> Invalid File");
	        		response.sendRedirect("UploadTimeTable.jsp");
	        	}
	        	else if(filePart.getSize() > 1048576 ){ //2mb
	        		out.println("<br/> File size too big");
	        		response.sendRedirect("UploadTimeTable.jsp");
	        	}
	        	pdfFileBytes = filePart.getInputStream();  // to get the body of the request as binary data
	 
	            final byte[] doc = new byte[pdfFileBytes.available()];
	            pdfFileBytes.read(doc);  //Storing the binary data in bytes array.
	            UploadTimeTableDAO uad=new UploadTimeTableDAO();
	            int ans=uad.uploadDocument(standard, doc);
	            if(ans > 0) {
	            	out.println("Timetable uploaded.");
	            }
	            else {
	            	response.sendRedirect("UploadTimeTable.jsp");
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
	    	response.sendRedirect("AdminLogin.jsp");
	    }
    	
	}

}
