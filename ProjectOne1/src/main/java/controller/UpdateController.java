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
* updating an existing reimbursement
*
* @author Brody
*
*/

public class UpdateController {

	static ReimbursementService myService = new ReimbursementServiceImpl();
	
	public static void updateReimbursement(HttpServletRequest req, HttpServletResponse resp) throws IOException {
 
//		int reimbId = 0;
//		int statusId = 0;
		
		ObjectMapper mapper = new ObjectMapper();
		ErsReimbursements reimbInput = mapper.readValue(req.getInputStream(), ErsReimbursements.class);
//		System.out.println(reimbInput.toString());
//		try {
			int reimbId = reimbInput.getReimbId();
			int statusId = reimbInput.getStatusId();
//		}catch(NumberFormatException e){
//			e.printStackTrace();
//		}
		
		
		HttpSession session = req.getSession();
		ErsUsers currentAccount =  (ErsUsers) session.getAttribute("currentAccount");
		
		int resolverId = currentAccount.getUserId();
		
		myService.updateReimbursement(reimbId, resolverId, statusId);
		

	}
}
