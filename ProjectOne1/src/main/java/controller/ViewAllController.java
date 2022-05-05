package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.ErsReimbursements;
import service.ReimbursementService;
import service.ReimbursementServiceImpl;
/**
*
* Controller used to process the array list of all
* reimbursements and send them as a JSON to webpage
*
* @author Brody
*
*/


public class ViewAllController {
	
	static ReimbursementService myService = new ReimbursementServiceImpl();

	public static void viewAllReimbursements(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//		System.out.println("in the controller");
		ArrayList<ErsReimbursements> thisReimbArray = myService.viewAllReimbursements();
		
		resp.setContentType("application/json");
		PrintWriter printer = resp.getWriter();

		printer.write(new ObjectMapper().writeValueAsString(thisReimbArray));
		
	}
	
}
