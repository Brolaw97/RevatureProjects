package frontcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * All web requests go through this page. It checks the url pattern and 
 * forwards to the router. 
 * A logged in method exists to see if any session exists before allowing a process to be done.
 * @author brody
 *
 */
@WebServlet(name = "MasterServlet", urlPatterns = { "/master/*", "/json/*", "/forwarding/*", "/redirecting/*", "/login" })
public class FrontController extends HttpServlet {

	
	protected boolean isLoggedIn(HttpServletRequest req) {
		if (!(req.getRequestURI().equals("/ProjectOne1/forwarding/login"))){
			HttpSession session = req.getSession(false);
//			System.out.println(session);
			if(session==null) {		
				return false;
			}else{
			return true;
		}  
			
		}return true;
		

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (isLoggedIn(req)) {
			Dispatcher.myVirtualRouterMethod(req, resp);
		} else {
			resp.getWriter().println("You're not logged in");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (isLoggedIn(req)) {
			Dispatcher.myVirtualRouterMethod(req, resp);
		} else {
			resp.getWriter().println("You're not logged in");
		}
	}
}
