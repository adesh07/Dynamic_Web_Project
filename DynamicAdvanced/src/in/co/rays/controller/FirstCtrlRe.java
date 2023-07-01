package in.co.rays.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.co.rays.bean.UserBean;

@WebServlet("/FirstCtrlRe")
public class FirstCtrlRe extends HttpServlet { // class for .sendRedirect();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("FirstCtrlRe : doGet()");

		String fname = req.getParameter("first_name");
		String lname = req.getParameter("last_name");

		System.out.println(fname);
		System.out.println(lname);

		resp.sendRedirect("SecondCtrl");

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("FirstCtrlRe : doPost()");

		String fname = req.getParameter("first_name");
		String lname = req.getParameter("last_name");

		System.out.println(fname);
		System.out.println(lname);

		resp.sendRedirect("SecondCtrl");
	}
}
