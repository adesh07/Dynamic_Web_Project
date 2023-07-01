package in.co.rays.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/UserCtrl.do")
public class UserCtrl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		UserModel model = new UserModel();

		try {
			UserBean bean = model.findByPk(Integer.parseInt(id));
			req.setAttribute("bean", bean);
			RequestDispatcher rd = req.getRequestDispatcher("Update.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("operation");
		String id = req.getParameter("id");
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
		
		if (op.equals("Update")) {
			bean.setId(Integer.parseInt(id));
			try {
				model.Update(bean);
				resp.sendRedirect("UserListCtrl.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}