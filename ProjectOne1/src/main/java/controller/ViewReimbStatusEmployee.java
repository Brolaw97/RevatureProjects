package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.ErsReimbursements;
import model.ErsUsers;
import service.ReimbursementService;
import service.ReimbursementServiceImpl;
/**
*
* Controller used to make an array list based on userId and 
* status to filter results on table on webpage.
*
* @author Brody
*
*/
public class ViewReimbStatusEmployee {
	
		static ReimbursementService myService = new ReimbursementServiceImpl();
			
			public static void viewByPending(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 		
				HttpSession session = req.getSession();
				ErsUsers currentAccount =  (ErsUsers) session.getAttribute("currentAccount");

				int authorId = currentAccount.getUserId();
				
//				System.out.println(authorId);
				
				ArrayList<ErsReimbursements> thisFoodArray = myService.selectByEmployeeIdAndStatus(authorId, 1);
//				System.out.println(thisFoodArray);
				if(thisFoodArray != null) {
				resp.setContentType("application/json");
				PrintWriter printer = resp.getWriter();

				printer.write(new ObjectMapper().writeValueAsString(thisFoodArray));
				}
				
			}	
			public static void viewByApproved(HttpServletRequest req, HttpServletResponse resp) throws IOException {
				 		
				HttpSession session = req.getSession();
				ErsUsers currentAccount =  (ErsUsers) session.getAttribute("currentAccount");

				int authorId = currentAccount.getUserId();
				
				ArrayList<ErsReimbursements> thisFoodArray = myService.selectByEmployeeIdAndStatus(authorId, 2);
				if(thisFoodArray != null) {
					resp.setContentType("application/json");
				PrintWriter printer = resp.getWriter();

				printer.write(new ObjectMapper().writeValueAsString(thisFoodArray));
				}
				
				
			}	
			public static void viewByDenied(HttpServletRequest req, HttpServletResponse resp) throws IOException {
				 
				HttpSession session = req.getSession();
				ErsUsers currentAccount =  (ErsUsers) session.getAttribute("currentAccount");

				int authorId = currentAccount.getUserId();
				
				ArrayList<ErsReimbursements> thisFoodArray = myService.selectByEmployeeIdAndStatus(authorId, 3);
				if(thisFoodArray != null) {
				resp.setContentType("application/json");
				PrintWriter printer = resp.getWriter();

				printer.write(new ObjectMapper().writeValueAsString(thisFoodArray));
				}
				
			}	
}


