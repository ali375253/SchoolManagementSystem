package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ReportCardServlet
 */
@WebServlet("/ReportCardServlet")
public class ReportCardServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		if(session.getAttribute("uname")!=null) {
			try {
				TermResultDAO trd=new TermResultDAO();
				ArrayList<TermResult> firstTermResult=trd.getFirstTermResult();
				ArrayList<TermResult> secondTermResult=trd.getSecondTermResult();
				ArrayList<TermResult> finalTermResult=trd.getFinalTermResult();
				ReportCardDAO rcd=new ReportCardDAO();
				for(int i=0;i<firstTermResult.size();i++) {
					TermResult ftr=firstTermResult.get(i);
					TermResult str=secondTermResult.get(i);
					TermResult ttr=finalTermResult.get(i);
					int reportcardid=Integer.parseInt(ftr.getStudentID()+""+ftr.getStandard());
					int studentid=ftr.getStudentID();
					int subject1=(ftr.getSubject1()+str.getSubject1()+ttr.getSubject1())/3;
					int subject2=(ftr.getSubject2()+str.getSubject2()+ttr.getSubject2())/3;
					int subject3=(ftr.getSubject3()+str.getSubject3()+ttr.getSubject3())/3;
					int subject4=(ftr.getSubject4()+str.getSubject4()+ttr.getSubject4())/3;
					int subject5=(ftr.getSubject5()+str.getSubject5()+ttr.getSubject5())/3;
					int total=subject1+subject2+subject3+subject4+subject5;
					int percentage=total/5;
					String result;
					if(subject1 >= 35 && subject2 >= 35 && subject3 >= 35 && subject4 >= 35 && subject5 >= 35 )
						result="PASS";
					else
						result="FAIL";
					int standard=ftr.getStandard();
					int ans=rcd.generateReportCard(reportcardid, studentid, subject1, subject2, subject3, subject4, subject5, total, percentage, result, standard);
					if(ans > 0)
						out.println("Report Generated.");
					else {
						out.println("Sorry, Something went wrong.. Try again");
						response.sendRedirect("AdminIndex.jsp");
					}
					
				}
			} 
			catch (ClassNotFoundException | SQLException e) {
				out.println(e.getMessage());
			}
		}
		else
			response.sendRedirect("AdminLogin.jsp");
	}
}
