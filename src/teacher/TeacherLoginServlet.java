package teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.AdminLoginDAO;

/**
 * Servlet implementation class TeacherLoginServlet
 */
@WebServlet("/TeacherLoginServlet")
public class TeacherLoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uname = Integer.parseInt(request.getParameter("teacherid"));
		String pwd = request.getParameter("password");
		PrintWriter out = response.getWriter();
			TeacherLoginDAO ald;
			out.println(uname);
			out.println(pwd);
			try {
				ald = new TeacherLoginDAO();
				if(ald.validate(uname, pwd))
				{
					HttpSession session=request.getSession();
					session.setAttribute("tchrid", Integer.toString(uname));
					response.sendRedirect("TeacherIndex.jsp");
				}
				else
				{
					response.sendRedirect("TeacherLogin.jsp");
				}
			} 
			catch (ClassNotFoundException | SQLException e) {
				out.println(e.getMessage());
			}
		out.close();
	}

}
