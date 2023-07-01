package in.co.rays.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/ThirdCtrl","/Hello", "*.ok"})
public class ThirdCtrlFo extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("doGet() method of ThirdCtrlFo");

		String fname = request.getParameter("first_name");
		String lname = request.getParameter("last_name");
		String[] address = request.getParameterValues("address");

		System.out.println(fname);
		System.out.println(lname);
		System.out.println(address[0]);
		System.out.println(address[1]);

//		request.setAttribute("xyz", "This is doGet() method of ThirdCtrl");

//		http://localhost:8088/DynamicAdvanced/ThirdCtrl?first_name=Adesh&last_name=Parteti&address=indore&address=jabalpur

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("doPost() method of ThirdCtrl");

//		System.out.println(request.getParameter("first_name"));
//		System.out.println(request.getParameter("last_name"));

		request.getAttribute("key");

	}

}
