package in.co.grade.sys.form;

import javax.validation.constraints.NotEmpty;

import in.co.grade.sys.dto.BaseDTO;
import in.co.grade.sys.dto.StudentDTO;
import in.co.grade.sys.util.DataUtility;

public class StudentForm extends BaseForm {

	@NotEmpty(message = "First Name is required")
	private String firstName;
	@NotEmpty(message = "Last is required")
	private String lastName;
	@NotEmpty(message = "Organization is required")
	private String organization;
	@NotEmpty(message = "Email Id is required")
	private String emailId;
	@NotEmpty(message = "City is required")
	private String city;
	@NotEmpty(message = "State is required")
	private String state;
	@NotEmpty(message = "Country is required")
	private String country;
	@NotEmpty(message = "Telephone No is required")
	private String telephone;
	@NotEmpty(message = "Fax No is required")
	private String fax;
	@NotEmpty(message = "Gender is required")
	private String gender;
	@NotEmpty(message = "Date Of Birth is required")
	private String dob;
	
	
	

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

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public BaseDTO getDTO() {
		StudentDTO dto = new StudentDTO();
		dto.setId(id);
		dto.setFirstName(firstName);
		dto.setLastName(lastName);
		dto.setOrganization(organization);
		dto.setEmailId(emailId);
		dto.setCity(city);
		dto.setState(state);
		dto.setCountry(country);
		dto.setTelephone(telephone);
		dto.setFax(fax);
		dto.setGender(gender);
		dto.setDob(DataUtility.getDate(dob));
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);
		return dto;
	}

	@Override
	public void populate(BaseDTO bdto) {
		StudentDTO dto = (StudentDTO) bdto;
		id=dto.getId();
		firstName=dto.getFirstName();
		lastName=dto.getLastName();
		organization=dto.getOrganization();
		emailId=dto.getEmailId();
		city=dto.getCity();
		state=dto.getState();
		country=dto.getCountry();
		telephone=dto.getTelephone();
		fax=dto.getFax();
		gender=dto.getGender();
		dob=DataUtility.getDateString(dto.getDob());
		createdBy=dto.getCreatedBy();
		modifiedBy=dto.getModifiedBy();
		createdDateTime=dto.getCreatedDatetime();
		modifiedDateTime=dto .getModifiedDatetime();
	}

}
