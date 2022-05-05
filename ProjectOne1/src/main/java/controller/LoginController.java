package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ErsUsers;
import service.UserService;
import service.UserServiceImpl;
/**
*
* Controller used to take in web request and check it against
* database to see if account exists. Then forward to the correct webpage depending
* on user-role.
*
* @author Brody
*
*/
public class LoginController {

	static UserService service = new UserServiceImpl();

	public static void logIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String myPath = null;

		// makes sure this is a post.
		if (!req.getMethod().equals("POST")) {
			myPath = "/index.html";
			req.getRequestDispatcher(myPath).forward(req, resp);
		}
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		ErsUsers currentUser = service.selectUserByCredentials(username, password);

		if (service.selectUserByCredentials(username, password) != null) {

			HttpSession session = req.getSession();
			session.setAttribute("currentAccount", currentUser);
			if (currentUser.getRoleId() == 2) {
				// Will be Manager html page
				myPath = "/resources/html/managerhome.html";
				req.getRequestDispatcher(myPath).forward(req, resp);
			} else {
				// Will be Normal Employee html page
				myPath = "/resources/html/employeehome.html";
				req.getRequestDispatcher(myPath).forward(req, resp);
			}

		} else {
			myPath = "/resources/html/badlogin.html";
			req.getRequestDispatcher(myPath).forward(req, resp);
		}
	}

}
