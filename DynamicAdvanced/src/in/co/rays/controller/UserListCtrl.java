package in.co.rays.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.co.rays.model.UserModel;

@WebServlet("/UserListCtrl.do")
public class UserListCtrl extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserModel model = new UserModel();
		try {
			List list = model.search();
			request.setAttribute("data", list);
			RequestDispatcher rd = request.getRequestDispatcher("UserListView.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doPost---------------------------------------------------UserListCtrl");
		
	}
}
