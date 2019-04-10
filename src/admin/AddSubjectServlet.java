package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DBConnection;

@WebServlet("/AddSubjectServlet")
public class AddSubjectServlet extends HttpServlet implements Servlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int subjectid=Integer.parseInt(request.getParameter("subjectid"));
		String subjectname=request.getParameter("subjectname");
		String standard=request.getParameter("standard");
		int subjectno=Integer.parseInt(request.getParameter("subjectno"));
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		if(session.getAttribute("uname")!=null) {
			try {
				AddSubjectDAO asd=new AddSubjectDAO();
				int ans=asd.addSubject(subjectid, subjectname, standard, subjectno);
				if(ans > 0) {
					out.println("Subject Added");
				}
				else {
					out.println("Sorry, Something went wrong.. Try again");
					response.sendRedirect("AddSubject.jsp");
				}
			} 
			catch (ClassNotFoundException | SQLException e) {
				out.println(e.getMessage());
			}
		}
		else {
			response.sendRedirect("AdminLogin.jsp");
		}
		
	}

}
