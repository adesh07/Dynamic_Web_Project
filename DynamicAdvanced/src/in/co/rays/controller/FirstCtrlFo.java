package in.co.rays.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstCtrlFo")
public class FirstCtrlFo extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("FirstCtrlFo :: doGet()");

		String fname = request.getParameter("first_name");
		String lname = request.getParameter("last_name");

		System.out.println(fname);
		System.out.println(lname);

		request.setAttribute("key", "Hello this is doGet() method message");

		RequestDispatcher rd = request.getRequestDispatcher("SecondCtrlFo");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("FirstCtrl :: doPost() method");

		String fname = request.getParameter("first_name");
		String lname = request.getParameter("last_name");

		System.out.println(fname);
		System.out.println(lname);

		request.setAttribute("key", "Hello this is doPost() method");

		RequestDispatcher rd = request.getRequestDispatcher("SecondCtrlFo");
		rd.forward(request, response);
	}
}
