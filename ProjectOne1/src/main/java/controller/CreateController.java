package controller;

import java.io.IOException;

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
 * Controller used to take in web request and send it to 
 * the service layer to process and send the response back 
 * creating a new reimbursement
 *
 * @author Brody
 *
 */
public class CreateController {

	static ReimbursementService myService = new ReimbursementServiceImpl();
	
	public static void createReimbursement(HttpServletRequest req, HttpServletResponse resp) throws IOException {
 
		ObjectMapper mapper = new ObjectMapper();
		ErsReimbursements reimbInput = mapper.readValue(req.getInputStream(), ErsReimbursements.class);
		
		double amount = reimbInput.getAmount();
		
		int typeId = reimbInput.getTypeId();
		
		HttpSession session = req.getSession();
		ErsUsers currentAccount =  (ErsUsers) session.getAttribute("currentAccount");

		int authorId = currentAccount.getUserId();
		
		myService.createReimbursement(amount, authorId, typeId);

	}
}
