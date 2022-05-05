package dao;

import java.util.ArrayList;

import model.ErsReimbursements;

public interface ReimbursementDao {

	// Insert
	// Most of the fields will be done automatically using the connection, Will likely have it do 3 buttons to take in type.
	// The only thing they'll have to enter will be amount.
	public boolean createReimbursement(double amount, int authorId, int typeId );

	// Modify
	// Used only by the Managers to update the status, takes in the id and what the new status Id will be
	// Automatically will set the resolver Id and date.
	public boolean updateReimbursement(int reimbId, int resolverId, int statusId);

		// Used to view all reimbursements by a specific employee, used by the employee to see their past reimbursements
		// will take in the Id automatically from session
	public ArrayList<ErsReimbursements> selectByEmployeeId(int employeeId);
	
	public ArrayList<ErsReimbursements> selectByEmployeeIdAndStatus(int employeeId, int statusId);
	
	// Used to filter the results by specific status types for Managers.
	public ArrayList<ErsReimbursements> selectByStatus(int statusId);
	// Used to have all reimbursements show up for the managers
	public ArrayList<ErsReimbursements> viewAllReimbursements();
	
}
