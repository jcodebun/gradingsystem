package in.co.grade.sys.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="LOCATION")
public class LocationDTO  extends BaseDTO{

	@Column(name="NAME",length = 225)
	private String name;
	
	
	
	@Override
	public String toString() {
		return "LocationDTO [name=" + name + ", id=" + id + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy
				+ ", createdDatetime=" + createdDatetime + ", modifiedDatetime=" + modifiedDatetime + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
