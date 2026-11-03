package in.co.grade.sys.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import in.co.grade.sys.dto.BaseDTO;
import in.co.grade.sys.dto.CourseToStudentDTO;
import in.co.grade.sys.dto.PaymentDTO;
import in.co.grade.sys.dto.ResultDTO;
import in.co.grade.sys.util.DataUtility;

public class PaymentForm extends BaseForm {

	@Min(value = 1, message = "Select Student Name")
	private long studentId;
	private String studentName;
	@NotEmpty(message = "Amount is required")
	@Pattern(regexp = "[+-]?[0-9]+", message = "Amount is Invalid")
	private String amount;
	@NotEmpty(message = "Date is required")
	private String date;
	


	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

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

	@Override
	public BaseDTO getDTO() {
		PaymentDTO dto = new PaymentDTO();
		dto.setId(id);
		dto.setStudentId(studentId);
		dto.setStudentName(studentName);
		dto.setAmount(DataUtility.getLong(amount));
		dto.setDate(DataUtility.getDate(date));
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);
		return dto;
	}

	@Override
	public void populate(BaseDTO bdto) {
		PaymentDTO dto = (PaymentDTO) bdto;
		id = dto.getId();
		studentId = dto.getStudentId();
		studentName = dto.getStudentName();
		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();
		createdDateTime = dto.getCreatedDatetime();
		modifiedDateTime = dto.getModifiedDatetime();
		amount=String.valueOf(dto.getAmount());
		date=DataUtility.getDateString(dto.getDate());
	}

}
