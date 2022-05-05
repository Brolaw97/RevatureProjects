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
* Controller used to make an array list based on userId to show results on table on webpage.
*
* @author Brody
*
*/
public class ViewController {

	static ReimbursementService myService = new ReimbursementServiceImpl();

	public static void viewReimbursements(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		HttpSession session = req.getSession();
		ErsUsers currentAccount =  (ErsUsers) session.getAttribute("currentAccount");
		
		int userId = currentAccount.getUserId();

		ArrayList<ErsReimbursements> thisFoodArray = myService.selectByEmployeeId(userId);

		resp.setContentType("application/json");
		PrintWriter printer = resp.getWriter();

		printer.write(new ObjectMapper().writeValueAsString(thisFoodArray));

	}

}
