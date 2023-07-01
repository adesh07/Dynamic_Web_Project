package in.co.rays.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/LoginCtrl")
public class LoginCtrl extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String op = request.getParameter("operation");

		if (op != null && op.equalsIgnoreCase("Logout")) {
			HttpSession session = request.getSession();
			session.invalidate();
		}
		RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String op = request.getParameter("operation");
		String uri = request.getParameter("uri");

		if (op.equalsIgnoreCase("Login")) {
			try {
				UserModel model = new UserModel();
				UserBean bean = model.authenticate(loginId, password);

				if (bean != null) {

					HttpSession session = request.getSession();
					session.setAttribute("fName", bean.getFirstName());

					// request.setAttribute("fName", bean.getFirstName());

					if (uri.equalsIgnoreCase("null")) {
						RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
						rd.forward(request, response);
					} else {
						response.sendRedirect(uri);
					}

				} else {
					System.out.println("Invalid details");
					request.setAttribute("msg", "Invalid loginId or Password");
					RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
					rd.forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (op.equalsIgnoreCase("Sign-up")) {
			response.sendRedirect("Registration.jsp");
		}
	}
}