package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErsReimbursements {

	private int reimbId;
	private double amount;
	private String submitDate;
	private String resolveDate;
	private int authorId;
	private int resolverId;
	private int statusId;
	private int typeId;
}
