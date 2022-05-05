package service;

import java.util.ArrayList;

import dao.ReimbursementDao;
import dao.ReimbursementDaoImpl;
import model.ErsReimbursements;

public class ReimbursementServiceImpl implements ReimbursementService {

	ReimbursementDao reimbDao = new ReimbursementDaoImpl();
	
	@Override
	public boolean createReimbursement(double amount, int authorId, int typeId) {
		return reimbDao.createReimbursement(amount, authorId, typeId);
	}

	@Override
	public boolean updateReimbursement(int reimbId, int resolverId, int statusId) {
		return reimbDao.updateReimbursement(reimbId, resolverId, statusId);
	}

	@Override
	public ArrayList<ErsReimbursements> selectByEmployeeId(int employeeId) {
		return reimbDao.selectByEmployeeId(employeeId);
	}

	@Override
	public ArrayList<ErsReimbursements> selectByStatus(int statusId) {
		return reimbDao.selectByStatus(statusId);
	}

	@Override
	public ArrayList<ErsReimbursements> viewAllReimbursements() {
		return reimbDao.viewAllReimbursements();
	}

	@Override
	public ArrayList<ErsReimbursements> selectByEmployeeIdAndStatus(int authorId, int statusId) {
		return reimbDao.selectByEmployeeIdAndStatus(authorId, statusId);
	}

}
