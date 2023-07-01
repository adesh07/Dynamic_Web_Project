package in.co.rays.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/SignUpCtrl")
public class SignUpCtrl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("operation");
		String fname = req.getParameter("first_name");
		String lname = req.getParameter("last_name");
		String loginId = req.getParameter("loginId");
		String pass = req.getParameter("password");
		String address = req.getParameter("address");

		UserBean bean = new UserBean();
		bean.setFirstName(fname);
		bean.setLastName(lname);
		bean.setloginId(loginId);
		bean.setPassword(pass);
		bean.setAddress(address);

		UserModel model = new UserModel();

		if (op.equals("Sign-up")) {
			try {
				model.add(bean);
				//req.setAttribute("Signup", "Sign-up Sucessful....Please Logoin");
				resp.sendRedirect("LoginView.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
