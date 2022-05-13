package project.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import project.service.AccountService;

@RestController
public class RegisterAccountController {

	/// Fields
	private AccountService accService;

	/// Constructors
		// No Args
	public RegisterAccountController() {
	}

		// All Args
	@Autowired
	public RegisterAccountController(AccountService accService) {
		super();
		this.accService = accService;
	}

	/// End Point
	@PostMapping(value = "/registeraccount")
	@ResponseStatus(HttpStatus.CREATED)
	public void registerAccount(HttpServletRequest req, HttpServletResponse resp) {

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		
		
		accService.registerAccount(username, password, firstName, lastName, email);
		
		
	}

}
