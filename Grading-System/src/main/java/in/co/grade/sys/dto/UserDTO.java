package in.co.grade.sys.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class UserDTO extends BaseDTO {

	@Column(name = "FIRST_NAME", length = 225)
	private String firstName;
	
	@Column(name = "LAST_NAME", length = 225)
	private String lastName;
	
	@Column(name = "LOGIN", length = 225)
	private String login;
	
	@Column(name = "PASSWORD", length = 225)
	private String password;
	
	@Column(name = "MOBILE_NO", length = 225)
	private String mobileNo;
	
	@Column(name = "ROLE_ID")
	private long roleId;
	
	@Column(name = "GENDER", length = 225)
	private String gender;
	
	
	

	public UserDTO() {
	}
	


	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
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
