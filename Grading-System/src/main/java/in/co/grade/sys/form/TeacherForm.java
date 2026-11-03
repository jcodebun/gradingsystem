package in.co.grade.sys.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import in.co.grade.sys.dto.BaseDTO;
import in.co.grade.sys.dto.TeacherDTO;
import in.co.grade.sys.util.DataUtility;

public class TeacherForm extends BaseForm {

	@NotEmpty(message = "First Name is required")
	private String firstName;
	@NotEmpty(message = "Last Name is required")
	private String lastName;
	@NotEmpty(message = "Email Id is required")
	private String emailId;
	@NotEmpty(message = "City is required")
	private String city;
	@NotEmpty(message = "State is required")
	private String state;
	@NotEmpty(message = "Country is required")
	private String country;
	@NotEmpty(message = "Phone No is required")
	private String phoneNo;
	@NotEmpty(message = "Address is required")
	private String address;
	@NotEmpty(message = "Salary is required")
	@Pattern(regexp = "[+-]?[0-9]+", message = "Salary is Invalid")
	private String salary;
	
	
	
	
	
	

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	

	@Override
	public BaseDTO getDTO() {
		TeacherDTO dto = new TeacherDTO();
		dto.setId(id);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setEmailId(emailId);
		dto.setCity(city);
		dto.setState(state);
		dto.setCountry(country);
		dto.setPhoneNo(phoneNo);
		dto.setAddress(address);
		dto.setSalary(DataUtility.getLong(salary));
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);
		return dto;
	}

	@Override
	public void populate(BaseDTO bdto) {
		TeacherDTO dto = (TeacherDTO) bdto;
		id=dto.getId();
		firstName=dto.getFirstName();
		lastName=dto.getLastName();
		emailId=dto.getEmailId();
		city=dto.getCity();
		state=dto.getState();
		country=dto.getCountry();
		phoneNo=dto.getPhoneNo();
		address=dto.getAddress();
		salary=String.valueOf(dto.getSalary());
		createdBy=dto.getCreatedBy();
		modifiedBy=dto.getModifiedBy();
		createdDateTime=dto.getCreatedDatetime();
		modifiedDateTime=dto .getModifiedDatetime();
	}

}
