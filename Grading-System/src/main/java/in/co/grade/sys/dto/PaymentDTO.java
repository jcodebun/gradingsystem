package in.co.grade.sys.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PAYMENT")
public class PaymentDTO extends BaseDTO {

	@Column(name="STUDENT_ID")
	private long studentId;
	@Column(name="STUDENT_NAME",length = 225)
	private String studentName;
	@Column(name="AMOUNT")
	private long amount;
	@Column(name="DATE")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	
	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String getKey() {
		return null;
	}

	@Override
	public String getValue() {
		return null;
	}

}
