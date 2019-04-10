package parent;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import teacher.Assignment;

@WebServlet("/ViewAssignmentServlet")
public class ViewAssignmentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		if(session.getAttribute("studid")!=null) {
			int parentid=Integer.parseInt((String)session.getAttribute("studid"));
			ViewAssignmentDAO vad;
			try {
				vad = new ViewAssignmentDAO();
				ArrayList<Assignment> as;
				as=vad.viewAssignment(parentid);
				out.println(as.size());
				RequestDispatcher rd=request.getRequestDispatcher("ViewAssignment.jsp");
				request.setAttribute("AssignmentList", as);
				rd.forward(request, response);
				
				//response.sendRedirect("ViewAssignment.jsp");
			} 
			catch (ClassNotFoundException | SQLException e) {
				out.println(e.getMessage());
			}
		}
		else {
			response.sendRedirect("ParentLogin.jsp");
		}
			
	}

}
