package frontcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CreateController;
import controller.LoginController;
import controller.LogoutController;
import controller.UpdateController;
import controller.ViewAllController;
import controller.ViewByStatusController;
import controller.ViewController;
import controller.ViewReimbStatusEmployee;
/**
 * A virtual router that forwards requests to different pages
 * causing different effects based on the URL it is sent to.
 * @author brody
 *
 */
public class Dispatcher {
	public static void myVirtualRouterMethod(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		switch(req.getRequestURI()) {
		case "/ProjectOne1/forwarding/allreimbursements":
			ViewAllController.viewAllReimbursements(req, resp);
			break;
			
		case "/ProjectOne1/forwarding/viewreimbursements":
			ViewController.viewReimbursements(req, resp);
			break;
			
		case "/ProjectOne1/forwarding/viewstatuspending":
			ViewByStatusController.viewByPending(req, resp);
			break;
			
		case "/ProjectOne1/forwarding/viewstatusapproved":
			ViewByStatusController.viewByApproved(req, resp);
			break;
			
		case "/ProjectOne1/forwarding/viewstatusdenied":
			ViewByStatusController.viewByDenied(req, resp);
			break;
			
		case "/ProjectOne1/forwarding/viewemployeepending":
			ViewReimbStatusEmployee.viewByPending(req, resp);
			break;
			
		case "/ProjectOne1/forwarding/viewemloyeeapproved":
			ViewReimbStatusEmployee.viewByApproved(req, resp);
			break;
			
		case "/ProjectOne1/forwarding/viewemployeedenied":
			ViewReimbStatusEmployee.viewByDenied(req, resp);
			break;
			
		case "/ProjectOne1/forwarding/createreimbursement":
			CreateController.createReimbursement(req, resp);
			break;
			
		case "/ProjectOne1/forwarding/updatereimbursement":
			UpdateController.updateReimbursement(req, resp);
			break;
			
		case "/ProjectOne1/forwarding/login":
			LoginController.logIn(req, resp);
			break;
		
		case "/ProjectOne1/forwarding/logout":
			LogoutController.logOut(req, resp);
			break;
			
		////////////////////////////////////////////////////////////////////////////	
		default:
				System.out.println("In default case, dude you gave me a bad url");
				
				req.getRequestDispatcher("/resources/html/badurl.html").forward(req, resp);
		}
	}
}	