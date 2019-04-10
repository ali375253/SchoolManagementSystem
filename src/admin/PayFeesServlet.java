package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PayFeesServlet
 */
@WebServlet("/PayFeesServlet")
public class PayFeesServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
			int studentid=Integer.parseInt(request.getParameter("studentid"));;
			String date=request.getParameter("date");
			String typeofpayment=request.getParameter("typeofpayment");
			int amount=Integer.parseInt(request.getParameter("amount"));;
			int standard=Integer.parseInt(request.getParameter("standard"));;
			int feesid=Integer.parseInt(""+studentid+standard);
			try {
				PayFeesDAO pfd = new PayFeesDAO();
				pfd.pay(feesid, studentid, date, typeofpayment, amount, standard);
			} catch (ClassNotFoundException | SQLException e) {
				out.println(e.getMessage());
			}
	}
}
