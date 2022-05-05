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
* Controller used to make an array list based on  
* status to filter results on table on webpage.
*
* @author Brody
*
*/
public class ViewByStatusController {
static ReimbursementService myService = new ReimbursementServiceImpl();
	
	public static void viewByPending(HttpServletRequest req, HttpServletResponse resp) throws IOException {
 		
		ArrayList<ErsReimbursements> thisFoodArray = myService.selectByStatus(1);
		
		resp.setContentType("application/json");
		PrintWriter printer = resp.getWriter();

		printer.write(new ObjectMapper().writeValueAsString(thisFoodArray));
		
	}	
	public static void viewByApproved(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 		
		ArrayList<ErsReimbursements> thisFoodArray = myService.selectByStatus(2);
		
		resp.setContentType("application/json");
		PrintWriter printer = resp.getWriter();

		printer.write(new ObjectMapper().writeValueAsString(thisFoodArray));
		
	}	
	public static void viewByDenied(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 
		
		ArrayList<ErsReimbursements> thisFoodArray = myService.selectByStatus(3);
		
		resp.setContentType("application/json");
		PrintWriter printer = resp.getWriter();

		printer.write(new ObjectMapper().writeValueAsString(thisFoodArray));
		
	}	
}
