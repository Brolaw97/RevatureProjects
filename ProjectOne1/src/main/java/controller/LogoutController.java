package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController {


	public static void logOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		session.invalidate();
		
		String myPath = "/index.html";
		req.getRequestDispatcher(myPath).forward(req, resp);
		
	}

}
