package in.co.grade.sys.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TEACHER")
public class TeacherDTO extends BaseDTO {

	@Column(name="FIRST_NAME",length = 225)
	private String firstName;
	@Column(name="LAST_NAME",length = 225)
	private String lastName;
	@Column(name="EMAIL_ID",length = 225)
	private String emailId;
	@Column(name="PHONE_NO",length = 225)
	private String phoneNo;
	@Column(name="COUNTRY",length = 225)
	private String country;
	@Column(name="STATE",length = 225)
	private String state;
	@Column(name="CITY",length = 225)
	private String city;
	@Column(name="ADDRESS",length = 225)
	private String address;
	@Column(name="SALARY")
	private long salary;
	
	
	
	
	
	
	@Override
	public String toString() {
		return "TeacherDTO [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", phoneNo="
				+ phoneNo + ", country=" + country + ", state=" + state + ", city=" + city + ", address=" + address
				+ ", salary=" + salary + ", id=" + id + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy
				+ ", createdDatetime=" + createdDatetime + ", modifiedDatetime=" + modifiedDatetime + "]";
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

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
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
