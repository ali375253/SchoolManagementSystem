package parent;

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
 * Servlet implementation class ParentLoginServlet
 */
@WebServlet("/ParentLoginServlet")
public class ParentLoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uname = Integer.parseInt(request.getParameter("studentid"));
		String pwd = request.getParameter("password");
		PrintWriter out = response.getWriter();
			ParentLoginDAO ald;
			out.println(uname);
			out.println(pwd);
			try {
				ald = new ParentLoginDAO();
				if(ald.validate(uname, pwd))
				{
					HttpSession session=request.getSession();
					session.setAttribute("studid", Integer.toString(uname));
					response.sendRedirect("ParentIndex.jsp");
				}
				else
				{
					response.sendRedirect("ParentLogin.jsp");
				}
			} 
			catch (ClassNotFoundException | SQLException e) {
				out.println(e.getMessage());
			}
		out.close();
	}
}