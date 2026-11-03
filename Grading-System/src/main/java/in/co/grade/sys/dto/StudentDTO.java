package in.co.grade.sys.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="STUDENT")
public class StudentDTO extends BaseDTO{

	@Column(name="FIRST_NAME",length = 225)
	private String firstName;
	@Column(name="LAST_NAME",length = 225)
	private String lastName;
	@Column(name="ORGANIZATION",length = 225)
	private String organization;
	@Column(name="EMAIL_ID",length = 225)
	private String emailId;
	@Column(name="CITY",length = 225)
	private String city;
	@Column(name="STATE",length = 225)
	private String state;
	@Column(name="COUNTRY",length = 225)
	private String country;
	@Column(name="TELEPHONE",length = 225)
	private String telephone;
	@Column(name="FAX",length = 225)
	private String fax;
	@Column(name="GENDER",length = 225)
	private String gender;
	@Column(name="DOB")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	

	@Override
	public String toString() {
		return "StudentDTO [firstName=" + firstName + ", lastName=" + lastName + ", organization=" + organization
				+ ", emailId=" + emailId + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", telephone=" + telephone + ", fax=" + fax + ", gender=" + gender + ", dob=" + dob + ", id=" + id
				+ ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", createdDatetime=" + createdDatetime
				+ ", modifiedDatetime=" + modifiedDatetime + "]";
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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

	

	@Override
	public String getKey() {
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		return firstName+" "+lastName;
	}
	

}
