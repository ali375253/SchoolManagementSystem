package admin;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
		PrintWriter out = response.getWriter();
			AdminLoginDAO ald;
			out.println(uname);
			out.println(pwd);
			try {
				ald = new AdminLoginDAO();
				if(ald.validate(uname, pwd))
				{
					HttpSession session=request.getSession();
					session.setAttribute("uname", uname);
					response.sendRedirect("AdminIndex.jsp");
				}
				else
				{
					response.sendRedirect("AdminLogin.jsp");
				}
			} 
			catch (ClassNotFoundException | SQLException e) {
				out.println(e.getMessage());
			}
		out.close();
	}
}