package parent;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import teacher.Assignment;

/**
 * Servlet implementation class ViewDoc
 */
@WebServlet("/ViewDoc")
public class ViewDoc extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		//ArrayList<Assignment> al= (ArrayList<Assignment>) session.getAttribute("aslist");
		/*int row=Integer.parseInt(request.getParameter("id"));
		ServletOutputStream sos;
		response.setContentType("application/pdf");
		response.reset();
		sos = response.getOutputStream();
		response.setHeader("Content-disposition","inline; filename="+ "ali"+".pdf" );
		String doc=String.valueOf(session.getAttribute(row+""));
		sos.write(doc.getBytes());
		sos.flush();
	    sos.close();
	    */
		ArrayList<Assignment> al1= (ArrayList<Assignment>) session.getAttribute("aslist");
		ServletOutputStream sos;
		response.setContentType("application/pdf");
		response.reset();
				sos = response.getOutputStream();
				int i=Integer.parseInt(request.getParameter("id"));
				Assignment as=al1.get(i);
				response.setHeader("Content-disposition","inline; filename="+ as.getAssignmentID()+".pdf" );
				sos.write(as.getDoc());
				sos.flush();
			    sos.close();
	}

}
