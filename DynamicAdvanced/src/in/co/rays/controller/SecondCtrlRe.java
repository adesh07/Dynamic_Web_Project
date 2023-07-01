package in.co.rays.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SecondCtrlRe")
public class SecondCtrlRe extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("SecondCtrlRe : doGet()");

		PrintWriter pw = resp.getWriter();
		pw.write("<h1> SecondCtrl : doGet </h1>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("SecondCtrlRe : doPost()");

		PrintWriter pw = resp.getWriter();
		pw.write("<h1> SecondCtrl : doPost </h1>");

	}

}
