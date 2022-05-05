package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ErsReimbursements;
/**
 *  All of the background logic that deals with the reimbursements.
 * @author brody
 *
 */


public class ReimbursementDaoImpl implements ReimbursementDao {

	
	
	// This is for creating a new reimbursement by normal employee
	@Override
	public boolean createReimbursement(double amount, int authorId, int typeId ) {
		try(Connection connect = ConnectionFactory.getConnection()){
			PreparedStatement ps = null;
														//		id,	amount, submit date, resolve date, authorID, resolverID, statusID, typeID) 
			String sql = "INSERT INTO ers_reimbursement VALUES(DEFAULT, ?, (SELECT now()) , null, ?, null, 1 , ?)";
			
			ps = connect.prepareStatement(sql);
			
			ps.setDouble(1, amount); 
			ps.setInt(2, authorId);
			ps.setInt(3, typeId);
			
			// Executes prepared statement
			ps.execute();	
		}
		catch (SQLException d) {
			d.printStackTrace();
		}
		return true;
	}

	// Used by managers to update/complete the reimbursements
	@Override
	public boolean updateReimbursement(int reimbId, int resolverId, int statusId) {
			try(Connection connect = ConnectionFactory.getConnection()){
			PreparedStatement ps = null;
		
			String sql = "UPDATE ers_reimbursement SET reimb_resolver = " + resolverId + ", reimb_status_id = " + statusId + ", "
					+ "reimb_resolved = (SELECT now()) WHERE reimb_id = " + reimbId;
			
			ps = connect.prepareStatement(sql);
			
			// Executes prepared statement
			ps.execute();	
		}
		catch (SQLException d) {
			d.printStackTrace();
		}
		return true;
	}

	// this is to be used by normal employees to see their reimbursements
	@Override
	public ArrayList<ErsReimbursements> selectByEmployeeId(int employeeId) {
		ArrayList<ErsReimbursements> myArray = new ArrayList<ErsReimbursements>();
		try(Connection connect = ConnectionFactory.getConnection()){
			ResultSet rs = null;
			PreparedStatement ps = null;
			
			String sql = "SELECT * FROM ers_reimbursement where reimb_author = " + employeeId + "ORDER BY reimb_id";
			
			
			ps = connect.prepareStatement(sql);
		
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				myArray.add(new ErsReimbursements(rs.getInt("reimb_id"), rs.getDouble("reimb_amount"), rs.getString("reimb_submitted"), 
													rs.getString("reimb_resolved"), rs.getInt("reimb_author"), rs.getInt("reimb_resolver"), 
													rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id")));
				
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}		return myArray;
	}

	
	// used by managers to filter all reimbursements by status
	@Override
	public ArrayList<ErsReimbursements> selectByStatus(int statusId) {
		ArrayList<ErsReimbursements> myArray = new ArrayList<ErsReimbursements>();
		try(Connection connect = ConnectionFactory.getConnection()){
			ResultSet rs = null;
			PreparedStatement ps = null;
			
			String sql = "SELECT * FROM ers_reimbursement where reimb_status_id = " + statusId + "ORDER BY reimb_id";
			
			
			ps = connect.prepareStatement(sql);
		
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				myArray.add(new ErsReimbursements(rs.getInt("reimb_id"), rs.getDouble("reimb_amount"), rs.getString("reimb_submitted"), 
													rs.getString("reimb_resolved"), rs.getInt("reimb_author"), rs.getInt("reimb_resolver"), 
													rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id")));
				
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}		return myArray;
	}

	// Will automatically run for managers
	@Override
	public ArrayList<ErsReimbursements> viewAllReimbursements() {
//		System.out.println("outside the try block");
		ArrayList<ErsReimbursements> myArray = new ArrayList<ErsReimbursements>();
		try(Connection connect = ConnectionFactory.getConnection()){
			ResultSet rs = null;
			PreparedStatement ps = null;
			
			String sql = "SELECT * FROM ers_reimbursement ORDER BY reimb_id";
			
			
			ps = connect.prepareStatement(sql);
		
			rs = ps.executeQuery();
			
			while(rs.next()) {
//				System.out.println("in the while block");
				myArray.add(new ErsReimbursements(rs.getInt("reimb_id"), rs.getDouble("reimb_amount"), rs.getString("reimb_submitted"), 
													rs.getString("reimb_resolved"), rs.getInt("reimb_author"), rs.getInt("reimb_resolver"), 
													rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id")));
				
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}		return myArray;
	}

	@Override
	public ArrayList<ErsReimbursements> selectByEmployeeIdAndStatus(int employeeId, int statusId) {
		ArrayList<ErsReimbursements> myArray = new ArrayList<ErsReimbursements>();
		try(Connection connect = ConnectionFactory.getConnection()){
			ResultSet rs = null;
			PreparedStatement ps = null;
			
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = ? AND reimb_status_id = ? ORDER BY reimb_id";
			
			
			ps = connect.prepareStatement(sql);
			ps.setInt(1, employeeId);
			ps.setInt(2, statusId);
			
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				myArray.add(new ErsReimbursements(rs.getInt("reimb_id"), rs.getDouble("reimb_amount"), rs.getString("reimb_submitted"), 
													rs.getString("reimb_resolved"), rs.getInt("reimb_author"), rs.getInt("reimb_resolver"), 
													rs.getInt("reimb_status_id"), rs.getInt("reimb_type_id")));
				
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}		return myArray;
	}
	

}
