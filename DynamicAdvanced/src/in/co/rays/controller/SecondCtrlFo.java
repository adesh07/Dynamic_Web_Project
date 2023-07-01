package in.co.rays.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;

@WebServlet("/SecondCtrlFo")
public class SecondCtrlFo extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String txt = (String) request.getAttribute("key");
		System.out.println(txt);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

		String txt = (String) request.getAttribute("key");
		System.out.println(txt);

		PrintWriter pw = response.getWriter();
		pw.write("doPost() method ");

		RequestDispatcher rd = request.getRequestDispatcher("ThirdCtrl");
		rd.forward(request, response);

	}
}