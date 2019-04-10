package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DBConnection;

@WebServlet("/UploadTermResultServlet")
public class UploadTermResultServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		
		if(session.getAttribute("uname") != null){
			int studentid=Integer.parseInt(request.getParameter("studentid"));
			int sub[]=new int[5];
			int total=0;
			for(int i=1;i<=5;i++) {
				sub[i-1]=Integer.parseInt(request.getParameter(i+""));
				total=total+sub[i-1];
			}
			String termtype=request.getParameter("termtype");
			double percentage=total/5;
			UploadTermResultDAO utrd=new UploadTermResultDAO();
			int standard=Integer.parseInt((String)session.getAttribute("standard"));
			try {
				int ans=utrd.uploadResult(studentid, sub[0], sub[1], sub[2], sub[3], sub[4], termtype, total, percentage, standard);
				if(ans > 0) {
					out.println("Result Uploaded");
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
