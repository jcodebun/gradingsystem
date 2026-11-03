package in.co.grade.sys.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="COURSE")
public class CourseDTO extends BaseDTO {


	@Column(name="NAME",length = 225)
	private String name;
	@Column(name="CREADIT_NUMBER")
	private long creaditNumber;
	@Column(name="DESCRIPTION",length = 225)
	private String description;
	
	
	
	@Override
	public String toString() {
		return "CourseDTO [name=" + name + ", creaditNumber=" + creaditNumber + ", description=" + description + ", id="
				+ id + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", createdDatetime="
				+ createdDatetime + ", modifiedDatetime=" + modifiedDatetime + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public long getCreaditNumber() {
		return creaditNumber;
	}

	public void setCreaditNumber(long creaditNumber) {
		this.creaditNumber = creaditNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getKey() {
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		return name;
	}

}
